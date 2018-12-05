package com.github.jargaw12.mailordercompanyrest.domain.repository;

import com.github.jargaw12.mailordercompanyrest.domain.Role;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String username);
}