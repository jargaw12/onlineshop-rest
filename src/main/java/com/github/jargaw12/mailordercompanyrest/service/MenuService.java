package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.ProductGroup;

public interface MenuService {
    public Iterable<ProductGroup> getProductGroups();
    public void getProductCategoriesInGroup(String group);
    public void getProductSubcategoriesInCategory(String category);
}
