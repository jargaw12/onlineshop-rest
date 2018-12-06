package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.*;
import com.github.jargaw12.mailordercompanyrest.service.EmailService;
import com.github.jargaw12.mailordercompanyrest.service.OrderService;
import com.github.jargaw12.mailordercompanyrest.service.PdfService;
import com.github.jargaw12.mailordercompanyrest.service.UserService;
import com.itextpdf.text.DocumentException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrdersController {
    private final OrderService orderService;
    private final PdfService pdfService;
    private final EmailService emailService;
    private final UserService userService;

    @Autowired
    public OrdersController(OrderService orderService, PdfService pdfService, EmailService emailService, UserService userService) {
        this.orderService = orderService;
        this.pdfService = pdfService;
        this.emailService = emailService;
        this.userService = userService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Order> findAllUserOrders(Authentication authentication) {
        return orderService.findAllByUsersByUserid(authentication.getName());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Order findOrderById(Authentication authentication, @PathVariable("id") long id) {
        return orderService.findByOrderById(authentication.getName(), id);
    }

    @PostMapping(path = "/addres/add")
    public  ResponseEntity<?> addAddress(Authentication authentication,
                           @RequestBody Address address) {
        Long id= orderService.addAddress(address);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(Authentication authentication,@RequestBody Order order) throws JRException, DocumentException, IOException, URISyntaxException, com.lowagie.text.DocumentException, MessagingException {
        Order o = new Order();
        Order order1 = orderService.addNewOrder(order,authentication.getName());
        List<OrderItem> orderdetails= orderService.addOrderDetails(authentication.getName(), order1);
        if (order1.getDeliveryByDeliveryid().getId()==2)
            orderService.sendOrder(order1, orderdetails);
        Users user=userService.getUserByUsername(authentication.getName());
        pdfService.generateInvoice(order1,orderdetails,user);
        emailService.sendEmail(user.getUsername(), order1);
        return new ResponseEntity<>(o, HttpStatus.CREATED);
    }
}
