package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.Product;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {
    public List<CartPosition> getProducts();
    public int getTotalQuantity();
    public void addProduct(Long id);
    public void plusminusProduct(long id, int quantity);
    public void removeProduct(long id);
}
