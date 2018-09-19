package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, path ="/shoppingcart")
    @ResponseStatus(HttpStatus.OK)
    public List<CartPosition> getProductsFromShoppingCart() {
        return shoppingCartService.getProducts();
    }
}
