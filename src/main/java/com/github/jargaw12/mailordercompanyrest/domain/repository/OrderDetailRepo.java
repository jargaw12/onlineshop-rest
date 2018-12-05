package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Orderdetails;
import com.github.jargaw12.mailordercompanyrest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepo extends JpaRepository<Orderdetails, Long> {

//    public List<Product> findAllByUser();
}
