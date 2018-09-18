package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.Product;

import java.util.List;
import java.util.Map;

public interface ShoppingCart {
    public List<CartPosition> getProducts();
}
