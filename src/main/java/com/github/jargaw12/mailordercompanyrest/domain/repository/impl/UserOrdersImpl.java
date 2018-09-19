package com.github.jargaw12.mailordercompanyrest.domain.repository.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Order;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserOrders;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserOrdersImpl implements UserOrders {
    List<Order> repository;

    public UserOrdersImpl() {
        repository = new ArrayList<>();
        Order o1=new Order(111111,1,new Date(2018,1,1),new Date(2018,2,1),"obiór własny","przedpłata","w trakcie realizacji",new BigDecimal(100.90));
        Order o2=new Order(222222,2,new Date(2018,2,2),new Date(2018,3,2),"paczkomat","przy odbiorze","zakończone",new BigDecimal(200.90));
        Order o3=new Order(333333,3,new Date(2018,3,3),new Date(2018,4,3),"kurier","przedpłata","zakończone",new BigDecimal(300.90));
        Order o4=new Order(444444,4,new Date(2018,4,4),new Date(2018,5,4),"obiór własny","przy odbiorze","zakończone",new BigDecimal(400.90));

        repository.add(o1);
        repository.add(o2);
        repository.add(o3);
        repository.add(o4);

    }

    @Override
    public List<Order> getAllUserOrders() {
        return repository;
    }

    @Override
    public Order getOrderByID(long id) {
        return repository.stream().filter(x->x.getOrderID()==id).findFirst().get();
    }
}
