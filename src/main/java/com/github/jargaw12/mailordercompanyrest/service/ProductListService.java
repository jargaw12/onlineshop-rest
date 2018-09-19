package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductListService {
    public List<Product> getProducts();

    Page<Product> findPaginated(int page, int size);
}
