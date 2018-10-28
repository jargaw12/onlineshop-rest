package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="/shoppingcart")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<CartPosition> getProductsFromShoppingCart() {
        return shoppingCartService.getProducts();
    }

    @RequestMapping(method = RequestMethod.GET, path ="/totalquantity")
    public int getTotalQuantityInOrder() {
        return shoppingCartService.getTotalQuantity();
    }

    @DeleteMapping(path="/{id}")
    public void delete(@PathVariable("id") int id){
        shoppingCartService.removeProduct(id);
        System.out.println("Usunieto produkt nr: " + id);
    }

    @PostMapping(path="/{id}")
    public ResponseEntity<?> plusminus(@PathVariable("id") int id, @RequestBody int quantity){
        shoppingCartService.plusminusProduct(id, quantity);
        System.out.println("Zmieniono liczbę kupionych produktów o: " + quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public void create(@RequestBody Long id){
        shoppingCartService.addProduct(id);
        System.out.println("Dodano nowy produkt: "+id);
    }
}
