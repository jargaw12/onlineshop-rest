package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.ProductGroup;
import com.github.jargaw12.mailordercompanyrest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(path = "/groups", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private Iterable<ProductGroup> getCategories() {
        return menuService.getProductGroups();
    }
}
