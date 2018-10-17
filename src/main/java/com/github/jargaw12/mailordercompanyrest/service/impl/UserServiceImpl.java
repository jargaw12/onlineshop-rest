package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserRepository;
import com.github.jargaw12.mailordercompanyrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void save(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    @Override
    public Users findByUsername(String username) {
        return repo.findUsersByUsername(username).get();
    }
}
