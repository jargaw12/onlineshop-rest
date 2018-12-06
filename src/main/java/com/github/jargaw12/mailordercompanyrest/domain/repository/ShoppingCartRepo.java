package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCartItem, Long> {
    @Query("select s " +
            "from ShoppingCartItem s " +
            "where s.buyer.id=:user")
    List<ShoppingCartItem> findByBuyer(@Param("user") long user);

    @Query("select s " +
            "from ShoppingCartItem s " +
            "where s.buyer.id=:user and s.item.id=:product")
    ShoppingCartItem findByBuyerAndItem(@Param("user") long user, @Param("product") long product);
}
