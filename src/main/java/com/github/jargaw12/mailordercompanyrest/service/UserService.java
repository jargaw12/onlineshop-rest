package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Users;

public interface UserService {
    Users getUserByUsername(String userName);
    Users changeUserData(String userName,Users newUser);
}
