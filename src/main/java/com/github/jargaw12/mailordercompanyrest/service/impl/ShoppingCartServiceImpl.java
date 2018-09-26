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

    @Override
    public int getTotalQuantity() {
        return shoppingCartRepo.getTotalQuantity();
    }

    @Override
    public CartPosition addProduct(CartPosition cartPosition) {
        shoppingCartRepo.getProducts().add(cartPosition);
        return null;
    }

    @Override
    public CartPosition plusProduct(CartPosition cartPosition) {
        shoppingCartRepo.getProducts().get(shoppingCartRepo.getProducts().indexOf(cartPosition)).setQuantity(shoppingCartRepo.getProducts().get(shoppingCartRepo.getProducts().indexOf(cartPosition)).getQuantity()+1);
        return shoppingCartRepo.getProducts().get(shoppingCartRepo.getProducts().indexOf(cartPosition));
    }

    @Override
    public CartPosition removeProduct(int id) {
        shoppingCartRepo.getProducts().remove(id);
        return null;
    }

    @Override
    public CartPosition minusProduct(CartPosition cartPosition) {
        shoppingCartRepo.getProducts().get(shoppingCartRepo.getProducts().indexOf(cartPosition)).setQuantity(shoppingCartRepo.getProducts().get(shoppingCartRepo.getProducts().indexOf(cartPosition)).getQuantity()-1);
        return null;
    }
}
