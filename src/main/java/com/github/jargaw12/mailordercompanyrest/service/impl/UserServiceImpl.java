package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Address;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.domain.repository.AddressRepo;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserRepository;
import com.github.jargaw12.mailordercompanyrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users getUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Users changeUserData(String userName,Users newUser) {
        Users user=getUserByUsername(userName);
        Address a=addressRepo.save(newUser.getAddress());
        user.setPhonenumber(newUser.getPhonenumber())
                .setFirstname(newUser.getFirstname())
                .setLastname(newUser.getLastname())
                .setAddress(a);
        Users u=userRepository.save(user);
        return u;
    }
}
