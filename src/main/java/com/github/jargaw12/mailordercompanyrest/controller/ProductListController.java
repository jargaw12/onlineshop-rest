package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping( path ="/productlist")
@RestController
public class ProductListController {
    @Autowired
    ProductListService productListService;

    @ResponseStatus(HttpStatus.OK)
    private List<Product> getProductList() {
        return productListService.getProducts();
    }

    @RequestMapping( params = { "page", "size" }, method =  RequestMethod.GET )
    public List<Product> findPaginated(
            @RequestParam( "page" ) int page, @RequestParam( "size" ) int size){
        Page<Product> resultPage = productListService.findPaginated( page, size );
        return resultPage.getContent();
    }
}
