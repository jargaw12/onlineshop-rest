package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.ProductSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSubcategoryRepo extends JpaRepository<ProductSubcategory,Long> {
    ProductSubcategory findById(long id);
    ProductSubcategory findBySubcategoryname(String name);



}
