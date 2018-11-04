package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface ProductListService {
    public Iterable<Product> getProducts();
//    Page<Product> findPaginated(int page, int size,long category, long subcategory);
    Product getProductById(long id);
    Page<Product> findPaginatedSorted(int page, int size, Sort.Direction direction, String name);
//    Page<Product> findProductsInSubcategory(long subcategory);
    Page<Product> getPage(long category, long subcategory, int number, int size, String dir, String order);

//    int getNumberOfPages(int size);
}
