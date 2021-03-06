package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Address;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/account")
public class UserAccountController {
    private final UserService userService;

    @Autowired
    public UserAccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Users getUserDetails(Authentication authentication) {
        return userService.getUserByUsername(authentication.getName());
    }

    @GetMapping(path = "/address")
    public Address getUserAddress(Authentication authentication) {
        return userService.getUserByUsername(authentication.getName()).getAddress();
    }

    @PostMapping(path = "/change")
    public ResponseEntity<?> changeData(Authentication authentication, @RequestBody Users user) {
        Users u=userService.changeUserData(authentication.getName(),user);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }
}
