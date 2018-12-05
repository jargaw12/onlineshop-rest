package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Users;

import javax.mail.MessagingException;

public interface SignupService {
    Users addUser(Users users);

    boolean findUser(String username);
}
