package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders, Long> {
    @Query("select o " +
            "from Orders o " +
            "where o.usersByUserid.username=:username")
    List<Orders> findAllByUsersByUserid(@Param("username") String username);

    @Query("select o " +
            "from Orders o " +
            "where o.usersByUserid.username=:username " +
            "and o.id=:id")
    Orders findByUsersByUseridAndId(@Param("username") String username, @Param("id") long id);
}
