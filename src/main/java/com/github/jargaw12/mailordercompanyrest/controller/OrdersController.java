package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.*;
import com.github.jargaw12.mailordercompanyrest.service.EmailSender;
import com.github.jargaw12.mailordercompanyrest.service.OrdersService;
import com.github.jargaw12.mailordercompanyrest.service.PdfService;
import com.github.jargaw12.mailordercompanyrest.service.UserService;
import com.itextpdf.text.DocumentException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @Autowired
    PdfService pdfService;

    @Autowired
    EmailSender emailSender;

    @Autowired
    UserService userService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Orders> findAllUserOrders(Authentication authentication) {
        return ordersService.findAllByUsersByUserid(authentication.getName());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Orders findOrderById(Authentication authentication, @PathVariable("id") long id) {
        return ordersService.findByOrderById(authentication.getName(), id);
    }

    @PostMapping(path = "/addres/add")
    public  ResponseEntity<?> addAddress(Authentication authentication,
                           @RequestBody Address address) {
        Long id=ordersService.addAddress(address);
                                  return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(Authentication authentication,@RequestBody Orders orders) throws JRException, DocumentException, IOException, URISyntaxException, com.lowagie.text.DocumentException, MessagingException {
        Orders o = new Orders();
        Orders orders1=ordersService.addNewOrder(orders,authentication.getName());
        List<Orderdetails> orderdetails=ordersService.addOrderDetails(authentication.getName(),orders1);
        if (orders1.getDeliveryByDeliveryid().getId()==2)
            ordersService.sendOrder(orders1, orderdetails);
        pdfService.generateInvoice(orders1,orderdetails,userService.getUserByUsername(authentication.getName()));
        emailSender.sendEmail("jarrcioo@gmail.com",orders1);
        return new ResponseEntity<>(o, HttpStatus.CREATED);
    }
}
