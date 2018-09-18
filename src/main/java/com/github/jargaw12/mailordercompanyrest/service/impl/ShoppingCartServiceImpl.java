package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ShoppingCart;
import com.github.jargaw12.mailordercompanyrest.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCart shoppingCartRepo;
    @Override
    public List<CartPosition> getProducts() {
        return shoppingCartRepo.getProducts();
    }
}
