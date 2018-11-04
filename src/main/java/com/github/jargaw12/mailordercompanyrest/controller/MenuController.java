package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.ProductGroup;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductGroupRepo;
import com.github.jargaw12.mailordercompanyrest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping(path ="/groups", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private Iterable<ProductGroup> getProductList() {
        return menuService.getProductGroups();
    }
}
