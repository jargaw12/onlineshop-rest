package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.ProductCategory;
import com.github.jargaw12.mailordercompanyrest.domain.ProductGroup;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Long> {
//    public ProductGroup findByName(String name);
//    public ProductGroup findByGroupName(String name);


}
