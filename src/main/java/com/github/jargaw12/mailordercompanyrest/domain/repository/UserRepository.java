package com.github.jargaw12.mailordercompanyrest.domain.repository;

import java.util.Optional;

import com.github.jargaw12.mailordercompanyrest.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
