package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Order;
import com.github.jargaw12.mailordercompanyrest.service.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    UserOrdersService userOrdersService;

    @RequestMapping(value="order/{orderID}", method= RequestMethod.GET)
    public Order getOrderById(
            @PathVariable("orderID") long orderID) {
        return userOrdersService.getOrderByID(orderID);
    }

    @RequestMapping(path="/orders", method= RequestMethod.GET)
    public List<Order> getAllOrders() {
        return userOrdersService.getAllUserOrders();
    }
}
