package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ShoppingCart;
import com.github.jargaw12.mailordercompanyrest.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCart shoppingCartRepo;

    @Override
    public List<CartPosition> getProducts() {
        List<CartPosition> productsInCart = new ArrayList<>();

        for (Long id : shoppingCartRepo.getProducts().keySet()) {
            productsInCart.add(new CartPosition(shoppingCartRepo.getProductById(id), shoppingCartRepo.getProducts().get(id)));
        }
        return productsInCart;
    }

    @Override
    public int getTotalQuantity() {
        OptionalInt total = shoppingCartRepo.getProducts().values().stream().mapToInt(x -> x.intValue()).reduce((sum, p) -> sum + p);
        return total.orElse(0);
    }

    @Override
    public void addProduct(Long id) {
        if (shoppingCartRepo.getProducts().containsKey(id))
            shoppingCartRepo.getProducts().put(id, shoppingCartRepo.getProducts().get(id) + 1);
        else shoppingCartRepo.getProducts().put(id, 1);
    }

    @Override
    public void plusminusProduct(long id, int quantity) {
        shoppingCartRepo.getProducts().put(id, shoppingCartRepo.getProducts().get(id) + quantity);
    }

    @Override
    public void removeProduct(long id) {
        shoppingCartRepo.getProducts().remove(id);
    }

}
