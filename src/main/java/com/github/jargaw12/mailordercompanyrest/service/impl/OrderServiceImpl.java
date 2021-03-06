package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jargaw12.mailordercompanyrest.domain.*;
import com.github.jargaw12.mailordercompanyrest.domain.TransportModel.AuthToken;
import com.github.jargaw12.mailordercompanyrest.domain.TransportModel.IncomeOrder;
import com.github.jargaw12.mailordercompanyrest.domain.TransportModel.OrderUser;
import com.github.jargaw12.mailordercompanyrest.domain.TransportModel.TransportOrder;
import com.github.jargaw12.mailordercompanyrest.domain.repository.*;
import com.github.jargaw12.mailordercompanyrest.service.OrderService;
import com.github.jargaw12.mailordercompanyrest.service.UserService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrdersRepo ordersRepo;
    private final AddressRepo addressRepo;
    private final ShoppingCartRepo shoppingCartRepo;
    private final UserService userService;
    private final OrderDetailRepo orderDetailRepo;
    private final ObjectMapper objectMapper;

    @Autowired
    public OrderServiceImpl(OrdersRepo ordersRepo, AddressRepo addressRepo, ObjectMapper objectMapper, OrderDetailRepo orderDetailRepo, UserService userService, ShoppingCartRepo shoppingCartRepo) {
        this.ordersRepo = ordersRepo;
        this.addressRepo = addressRepo;
        this.objectMapper = objectMapper;
        this.orderDetailRepo = orderDetailRepo;
        this.userService = userService;
        this.shoppingCartRepo = shoppingCartRepo;
    }

    @Override
    public List<Order> findAllByUsersByUserid(String username) {
        return ordersRepo.findAllByUsersByUserid(username);
    }

    @Override
    public Order findByOrderById(String username, long id) {
        return ordersRepo.findByUsersByUseridAndId(username, id);
    }

    @Override
    public Order addNewOrder(Order order, String username) {
        Users user = userService.getUserByUsername(username);
        Order order1 = new Order()
                .setAddressByAdresId(user.getAddress())
                .setCreatedtime(Date.valueOf(LocalDate.now()))
                .setDeliverycost(order.getDeliverycost())
                .setTotalprice(order.getTotalprice())
                .setUsersByUserid(user)
                .setPaymentByPaymentid(order.getPaymentByPaymentid())
                .setDeliveryByDeliveryid(order.getDeliveryByDeliveryid());
        return ordersRepo.save(order1);
    }

    @Override
    public List<OrderItem> addOrderDetails(String username, Order order) {
        Users user = userService.getUserByUsername(username);
        List<ShoppingCartItem> items = shoppingCartRepo.findByBuyer(user.getId());
//        items.stream().forEach(i->orderDetailRepo.save(new OrderItem()
//                .setQuantity(i.getQuantity())
//                .setOrderByOrderId(order)
//                .setProductByProductid(i.getItem())));
        List<OrderItem> list = items.stream()
                .map(i -> (new OrderItem()
                        .setQuantity(i.getQuantity())
                        .setOrderByOrderId(order)
                        .setProductByProductid(i.getItem())))
                .collect(Collectors.toCollection(ArrayList::new));
        orderDetailRepo.saveAll(list);
        shoppingCartRepo.deleteAll(items);
        return list;
    }

    @Override
    public Long addAddress(Address address) {
        Address address1 = new Address();
        address1.setCity(address.getCity());
        address1.setPostcode(address.getPostcode());
        address1.setStreet(address.getStreet());
        address1.setStreetnumber(address.getStreetnumber());
        Address address2 = addressRepo.save(address1);
        return address2.getId();
    }

    @Override
    public int sendOrder(Order orders, List<OrderItem> orderdetails) throws IOException {
        String token = getAuth();
        String to=
                orders.getAddressByAdresId().getStreet() + " "
                +orders.getAddressByAdresId().getStreetnumber()+", "
                + orders.getAddressByAdresId().getCity()+ " "
                + orders.getAddressByAdresId().getPostcode();
        String from="Urbanowicza 11, 01-476 Warszawa";
        LocalDate date= LocalDate.now();
        LocalDate dateTo= LocalDate.now().plusDays(3);
        double weight= orderdetails.stream().mapToInt(OrderItem::getQuantity).sum()*0.2;

        IncomeOrder order=new IncomeOrder(from,to,date,dateTo,weight);
        String json = getJSON("http://danielapp.eu-west-1.elasticbeanstalk.com/incomeOrders/addNew",order,token,true);
        TransportOrder order1 = new ObjectMapper().readValue(json, TransportOrder.class);
        return order1.getOrderNo();
    }

    private String getAuth() throws IOException {
        OrderUser user=new OrderUser("JarekOdPralek","Password1!");
        String json = getJSON("http://danielapp.eu-west-1.elasticbeanstalk.com/api/auth/login",user,null,false);
        AuthToken authToken = objectMapper.readValue(json, AuthToken.class);
        return authToken.getAccessToken();
    }

    private String getJSON(String path,Object body, String token, boolean authorization) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost postMethod = new HttpPost(path);
        String json = objectMapper.writeValueAsString(body);
        StringEntity requestEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        postMethod.setEntity(requestEntity);
        postMethod.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        if (authorization)
            postMethod.setHeader(HttpHeaders.AUTHORIZATION, "Bearer "+token);
        HttpResponse responseBody  = client.execute(postMethod);
        return EntityUtils.toString(responseBody.getEntity());
    }
}
