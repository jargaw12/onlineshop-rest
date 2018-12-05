package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.exceptions.RecordNotFoundException;
import com.github.jargaw12.mailordercompanyrest.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping(path = "/products")
public class ProductListController {
    @Autowired
    ProductListService productListService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private Iterable<Product> getAllProductList(@RequestParam(value = "page") int number,
                                                @RequestParam(value = "size") int size) {
        return productListService.getProducts(number, size);
    }

    @RequestMapping(path = "/{category}", method = RequestMethod.GET)
    public Page<Product> getPageByCategory(@PathVariable(value = "category") long category,
                                           @RequestParam(value = "page") int number,
                                           @RequestParam(value = "size") int size,
                                           @RequestParam(value = "order", required = false) String order,
                                           @RequestParam(value = "dir", required = false) String dir) {
        return productListService.getPage(category, 0, number, size, dir, order);
    }

    @RequestMapping(path = "/{category}/{subcategory}", method = RequestMethod.GET)
    public Page<Product> getPageByCategoryAndSubcategory(@PathVariable(value = "category") long category,
                                                         @PathVariable(value = "subcategory", required = false) long subcategory,
                                                         @RequestParam(value = "page") int number,
                                                         @RequestParam(value = "size") int size,
                                                         @RequestParam(value = "order", required = false) String order,
                                                         @RequestParam(value = "dir", required = false) String dir) {
        return productListService.getPage(category, subcategory, number, size, dir, order);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") long id) {
        Product p = productListService.getProductById(id);
        if (p == null) throw new RecordNotFoundException("Invalid product id : " + id);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
        Product p = productListService.getProductById(id);
        productListService.removeProduct(p);
        System.out.println("Usunieto produkt nr: " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product p = new Product();
        p.setImage(product.getImage());
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setSubcategoryid(product.getSubcategoryid());
        productListService.addProduct(p);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
}
