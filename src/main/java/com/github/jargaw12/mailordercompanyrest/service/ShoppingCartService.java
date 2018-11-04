package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;

import java.util.List;

public interface ShoppingCartService {
    public List<CartPosition> getProducts();
    public int getTotalQuantity();
    public void addProduct(Long id);
    public void plusminusProduct(long id, int quantity);
    public void removeProduct(long id);
}
