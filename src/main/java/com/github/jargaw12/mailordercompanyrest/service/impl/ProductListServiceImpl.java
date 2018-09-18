package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductList;
import com.github.jargaw12.mailordercompanyrest.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductListServiceImpl implements ProductListService {
    @Autowired
    ProductList productListRepo;
    @Override
    public List<Product> getProducts() {
        return productListRepo.getProducts();
    }
}
