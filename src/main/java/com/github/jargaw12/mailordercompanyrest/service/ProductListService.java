package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductListService {
    public Iterable<Product> getProducts();
    Page<Product> findPaginated(int page, int size);
    Product getProductById(long id);
    Page<Product> findPaginatedSorted(int page, int size, Sort.Direction direction, String name);

//    int getNumberOfPages(int size);
}
