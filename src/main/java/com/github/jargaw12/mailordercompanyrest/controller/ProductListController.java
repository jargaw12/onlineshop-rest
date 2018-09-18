package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductListController {
    @Autowired
    ProductListService productListService;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(method = RequestMethod.GET, path ="/productlist")
    @ResponseStatus(HttpStatus.FOUND)
    private List<Product> getProductList() {
        return productListService.getProducts();
    }
}
