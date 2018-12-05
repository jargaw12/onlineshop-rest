package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Orders;

import java.util.List;

public interface UserOrdersService {
    List<Orders> getAllUserOrders();

    Orders getOrderByID(long id);
}
