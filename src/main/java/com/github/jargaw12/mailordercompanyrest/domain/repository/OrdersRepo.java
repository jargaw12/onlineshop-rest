package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Order, Long> {
    @Query("select o " +
            "from Order o " +
            "where o.usersByUserid.username=:username")
    List<Order> findAllByUsersByUserid(@Param("username") String username);

    @Query("select o " +
            "from Order o " +
            "where o.usersByUserid.username=:username " +
            "and o.id=:id")
    Order findByUsersByUseridAndId(@Param("username") String username, @Param("id") long id);
}
