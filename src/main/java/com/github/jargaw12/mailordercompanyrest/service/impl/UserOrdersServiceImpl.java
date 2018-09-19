package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Order;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserOrders;
import com.github.jargaw12.mailordercompanyrest.service.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrdersServiceImpl implements UserOrdersService {
    @Autowired
    UserOrders userOrdersRep;
    @Override
    public List<Order> getAllUserOrders() {
        return userOrdersRep.getAllUserOrders();
    }

    @Override
    public Order getOrderByID(long id) {
        return userOrdersRep.getOrderByID(id);
    }
}
