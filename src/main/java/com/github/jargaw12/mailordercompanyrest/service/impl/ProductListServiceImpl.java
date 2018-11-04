package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductList;
import com.github.jargaw12.mailordercompanyrest.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductListServiceImpl implements ProductListService {
    @Autowired
    ProductList productListRepo;

    @Override
    public Iterable<Product> getProducts() {
        return productListRepo.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productListRepo.findProductById(id);
    }

//    @Override
//    public Page<Product> findPaginated(int page, int size,long category, long subcategory) {
//        if (subcategory!=0)
//            return productListRepo.findAllProductInSubcategory(subcategory,PageRequest.of(page,size));
//        return productListRepo.findAllProductInCategory(category,PageRequest.of(page,size));
//    }

    @Override
    public Page<Product> findPaginatedSorted(int page, int size, Sort.Direction direction, String name) {
        return productListRepo.findAll(PageRequest.of(page-1,size,direction,name));
    }

//    @Override
//    public Page<Product> findProductsInSubcategory(long subcategory) {
//        return productListRepo.findBySubcategory(subcategory);
//    }

    @Override
    public Page<Product> getPage(long category, long subcategory, int number, int size, String dir, String order) {
        Sort.Direction direction;
        if (order!=null&&dir!=null){
            direction= Sort.Direction.fromString(dir.toUpperCase());
//            return findPaginatedSorted(number, size, direction, order);
        }
        else{
            direction= Sort.Direction.ASC;
            order="id";
        }
        if (subcategory!=0)
            return productListRepo.findAllProductInSubcategory(category,subcategory,PageRequest.of(number-1,size,direction,order));
        return productListRepo.findAllProductInCategory(category,PageRequest.of(number-1,size,direction,order));
    }

}
