package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductGroupRepo extends JpaRepository<ProductGroup,Long> {
    ProductGroup findById(long id);
    ProductGroup findByName(String name);
}
