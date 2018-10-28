package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.exceptions.RecordNotFoundException;
import com.github.jargaw12.mailordercompanyrest.service.ProductListService;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ProductListController {
    @Autowired
    ProductListService productListService;

    @RequestMapping(path ="/allProductlist", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private Iterable<Product> getProductList() {
        return productListService.getProducts();
    }


    @RequestMapping(path = "/productlist",method =  RequestMethod.GET )
    public Page<Product> findPaginated(@RequestParam( value = "page") int number,
                                       @RequestParam(value = "size") int size,
                                       @RequestParam(value = "order", required = false) String order,
                                       @RequestParam(value = "dir", required = false) String dir){
        if (order!=null){
            Sort.Direction direction= Sort.Direction.ASC;
            if (dir!=null){
                direction= Sort.Direction.fromString(dir.toUpperCase());
            }
            Page<Product> paginatedSorted = productListService.findPaginatedSorted(number, size, direction, order);
            return paginatedSorted;
        }
        return productListService.findPaginated(number, size);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/product/{id}",method =  RequestMethod.GET )
    public ResponseEntity<Product> findProduct(@PathVariable( value = "id") long id){
        Product p= productListService.getProductById(id);
        if (p==null) throw new RecordNotFoundException("Invalid employee id : " + id);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }
}
