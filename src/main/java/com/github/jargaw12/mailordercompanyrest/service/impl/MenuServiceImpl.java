package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.ProductGroup;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductGroupRepo;
import com.github.jargaw12.mailordercompanyrest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    private final ProductGroupRepo productGroup;

    @Autowired
    public MenuServiceImpl(ProductGroupRepo productGroup) {
        this.productGroup = productGroup;
    }

    @Override
    public Iterable<ProductGroup> getProductGroups() {
        return productGroup.findAll();
    }
}
