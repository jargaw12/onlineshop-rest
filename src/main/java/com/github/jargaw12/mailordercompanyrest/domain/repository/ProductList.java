package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.ProductGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductList extends JpaRepository<Product, Long> {
    Product findProductById(Long id);

    @Query("select p " +
            "from Product p " +
            "join ProductSubcategory s on p.subcategoryid=s.id " +
            "join ProductCategory c on s.categoryid=c.id " +
            "where c.id=:categoryid")
    Page<Product> findAllProductInCategory(@Param("categoryid") long categoryid, Pageable pageable);

    @Query("select p " +
            "from Product p " +
            "join ProductSubcategory s on p.subcategoryid=s.id " +
            "where s.categoryid=:categoryid " +
            "and s.id=:subcategoryid")
    Page<Product> findAllProductInSubcategory(@Param("categoryid") long categoryid, @Param("subcategoryid") long subcategoryid, Pageable pageable);

}
