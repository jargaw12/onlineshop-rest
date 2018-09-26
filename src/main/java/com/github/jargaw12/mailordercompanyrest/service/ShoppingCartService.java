package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.Product;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {
    public List<CartPosition> getProducts();
    public int getTotalQuantity();
    public CartPosition addProduct(CartPosition cartPosition);
    public CartPosition plusProduct(CartPosition cartPosition);
    public CartPosition removeProduct(int id);
    public CartPosition minusProduct(CartPosition cartPosition);

}
