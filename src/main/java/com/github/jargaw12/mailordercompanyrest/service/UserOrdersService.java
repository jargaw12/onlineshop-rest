package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Order;

import java.util.List;

public interface UserOrdersService {
    public List<Order> getAllUserOrders();
    public Order getOrderByID(long id);
}
