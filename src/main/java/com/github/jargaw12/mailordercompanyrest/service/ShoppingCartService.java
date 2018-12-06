package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.ShoppingCartItem;

import javax.mail.MessagingException;
import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCartItem> getProducts(String username);

    int getTotalQuantity(String username);

    void addProduct(Long id, String username);

    void plusminusProduct(long id, int quantity, String username);

    void removeProduct(long id, String username);
}
