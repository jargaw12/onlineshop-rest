package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
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

//    @RequestMapping(method=RequestMethod.POST)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public String removeProductFromCart (@RequestBody CartPosition cartPosition) {
//        shoppingCartService.removeProduct(cartPosition);
//        return "redirect:/";
//    }

//    @RequestMapping(method=RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public String incrementCart (@RequestBody CartPosition cartPosition) {
//        shoppingCartService.plusProduct(cartPosition);
//        return "redirect:/";
//    }

//    @RequestMapping(method=RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public String deleteProduct (@RequestBody CartPosition cartPosition) {
//        shoppingCartService.removeProduct(cartPosition);
//        return "redirect:/";
//    }

    @DeleteMapping(path="/{id}")
    public void delete(@PathVariable("id") int id){
        shoppingCartService.removeProduct(id);
    }
}
