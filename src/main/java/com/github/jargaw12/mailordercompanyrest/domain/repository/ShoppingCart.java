package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Product;

import java.util.Map;

public interface ShoppingCart {
    public Map<Long, Integer> getProducts();
    public Product getProductById(Long id);
}
