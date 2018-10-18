/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jargaw12.mailordercompanyrest.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import com.github.jargaw12.mailordercompanyrest.domain.CustomUserDetail;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/**
 *
 * @author developer
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("loadUserByUsername----");
//        Users users = repo.findByUsername(username);
//        if(users == null){
//            throw new UsernameNotFoundException("UserName "+username+" not found");
//        }
////        users.setPassword(passwordEncoder.encode(users.getPassword()));
//        return new CustomUserDetail(users);
        Users u=repo.findByUsername(username);
        UserDetails userDetails=null;
        if (u!=null){
            userDetails =User.withDefaultPasswordEncoder().username(u.getUsername()).password(u.getPassword()).roles(u.getRoles().get(0).getName()).build();

        }
        else  throw new UsernameNotFoundException("No user with "
                + "the name " + username + "was found in the database");
        return userDetails;
    }

}