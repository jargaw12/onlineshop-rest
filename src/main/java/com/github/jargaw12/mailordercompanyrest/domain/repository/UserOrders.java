package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Order;

import java.util.List;

public interface UserOrders {
    public List<Order> getAllUserOrders();
    public Order getOrderByID(long id);
}
