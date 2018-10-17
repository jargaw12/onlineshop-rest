package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Users;

public interface UserService {
    Users findByUsername(String username);
    void save(Users user);
}
