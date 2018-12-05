package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Orders;

import java.util.List;

public interface UserOrders {
    List<Orders> getAllUserOrders();

    Orders getOrderByID(long id);
}
