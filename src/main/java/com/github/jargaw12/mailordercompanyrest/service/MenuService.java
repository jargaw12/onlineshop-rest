package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.ProductGroup;

public interface MenuService {
    Iterable<ProductGroup> getProductGroups();
}
