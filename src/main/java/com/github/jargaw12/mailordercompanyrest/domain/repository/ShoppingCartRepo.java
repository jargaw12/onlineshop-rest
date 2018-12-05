package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Shoppingcart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingCartRepo extends JpaRepository<Shoppingcart, Long> {
    @Query("select s " +
            "from Shoppingcart s " +
            "where s.buyer.id=:user")
    List<Shoppingcart> findByBuyer(@Param("user") long user);

    @Query("select s " +
            "from Shoppingcart s " +
            "where s.buyer.id=:user and s.item.id=:product")
    Shoppingcart findByBuyerAndItem(@Param("user") long user, @Param("product") long product);
}
