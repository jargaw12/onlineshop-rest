package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.exceptions.RecordNotFoundException;
import com.github.jargaw12.mailordercompanyrest.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ProductListController {
    @Autowired
    ProductListService productListService;

    @RequestMapping(path ="/productlist", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private Iterable<Product> getProductList() {
        return productListService.getProducts();
    }


    @RequestMapping(path = "/productlist/page",method =  RequestMethod.GET )
    public Page<Product> findPaginated(@RequestParam( value = "number") int number,
                                       @RequestParam(value = "size") int size){
        Page<Product> resultPage = productListService.findPaginated( number, size );
        return resultPage;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/product/{id}",method =  RequestMethod.GET )
    public ResponseEntity<Product> findProduct(@PathVariable( value = "id") long id){
        Product p= productListService.getProductById(id);
        if (p==null) throw new RecordNotFoundException("Invalid employee id : " + id);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }
}
