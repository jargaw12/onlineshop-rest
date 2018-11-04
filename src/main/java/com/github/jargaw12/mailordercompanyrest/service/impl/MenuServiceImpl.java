package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.ProductGroup;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductCategoryRepo;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductGroupRepo;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductSubcategoryRepo;
import com.github.jargaw12.mailordercompanyrest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    ProductGroupRepo productGroup;

    @Autowired
    ProductCategoryRepo productCategory;

    @Autowired
    ProductSubcategoryRepo productSubcategory;

    @Override
    public Iterable<ProductGroup> getProductGroups() {
        return productGroup.findAll();
    }

    @Override
    public void getProductCategoriesInGroup(String group) {

    }

    @Override
    public void getProductSubcategoriesInCategory(String category) {

    }
}
