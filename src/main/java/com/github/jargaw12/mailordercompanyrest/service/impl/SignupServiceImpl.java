package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Role;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.domain.repository.RoleRepository;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserRepository;
import com.github.jargaw12.mailordercompanyrest.service.EmailService;
import com.github.jargaw12.mailordercompanyrest.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;


@Service
@Transactional
public class SignupServiceImpl implements SignupService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignupServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users addUser(Users users) {
        Role role=roleRepository.findByName("USER");
        Users usersTmp= users.setRoles(Arrays.asList(role));
        usersTmp.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(usersTmp);
    }

    @Override
    public boolean findUser(String email) {
        Users users = userRepository.findByUsername(email);
        return users != null;
    }
}
