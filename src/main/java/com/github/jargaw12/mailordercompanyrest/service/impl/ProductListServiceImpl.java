package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductList;
import com.github.jargaw12.mailordercompanyrest.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

    @Override
    public Page<Product> findPaginated(int page, int size) {
        if (size * page <= productListRepo.getProducts().size())
            return new PageImpl<>(productListRepo.getProducts().subList(size * (page - 1), size * page - 1));
        else
            return new PageImpl<>(productListRepo.getProducts().subList(size * (page - 1), productListRepo.getProducts().size()));
    }
}
