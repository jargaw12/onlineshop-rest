package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.Shoppingcart;

import javax.mail.MessagingException;
import java.util.List;

public interface ShoppingCartService {
    List<Shoppingcart> getProducts(String username);

    int getTotalQuantity(String username);

    void addProduct(Long id, String username) throws MessagingException;

    void plusminusProduct(long id, int quantity, String username);

    void removeProduct(long id, String username);
}
