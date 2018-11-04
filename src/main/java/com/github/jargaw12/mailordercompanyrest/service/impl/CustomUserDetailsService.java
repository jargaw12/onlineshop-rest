/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.CustomUserDetail;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author developer
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;

    @Autowired
    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = repo.findByEmailaddress(email);
        if(users == null){
            throw new UsernameNotFoundException("Email "+email+" not found");
        }
        UserDetails customUserDetails=new CustomUserDetail(users);
        return new User(customUserDetails.getUsername(),customUserDetails.getPassword(),customUserDetails.getAuthorities());
    }
}