package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface ProductListService {
    Iterable<Product> getProducts(int page, int size);

    Product getProductById(long id);

    Page<Product> findPaginatedSorted(int page, int size, Sort.Direction direction, String name);

    Page<Product> getPage(long category, long subcategory, int number, int size, String dir, String order);

    void removeProduct(Product product);

    Product addProduct(Product product);
}
