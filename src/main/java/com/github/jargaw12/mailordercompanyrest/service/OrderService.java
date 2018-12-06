package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Address;
import com.github.jargaw12.mailordercompanyrest.domain.Order;
import com.github.jargaw12.mailordercompanyrest.domain.OrderItem;
import com.lowagie.text.DocumentException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface OrderService {
    List<Order> findAllByUsersByUserid(String username);
    @Query("select o from Order o where o.id=:id and o.usersByUserid.username=:username")
    Order findByOrderById(@Param("username") String username, @Param("id") long id);
    Order addNewOrder(Order order, String username);
    List<OrderItem> addOrderDetails(String username, Order order);
    Long addAddress(Address address);
    int sendOrder(Order order, List<OrderItem> orderdetails) throws IOException;
}
