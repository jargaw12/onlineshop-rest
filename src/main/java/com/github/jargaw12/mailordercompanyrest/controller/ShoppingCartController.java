package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @CrossOrigin()
    @RequestMapping(method = RequestMethod.GET, produces="application/json", path ="/shoppingcart")
    @ResponseStatus(HttpStatus.OK)
    public List<CartPosition> getProductsFromShoppingCart() {

        return shoppingCartService.getProducts();
    }
}
