package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Role;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.service.SignupService;
import com.github.jargaw12.mailordercompanyrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
@RestController
@CrossOrigin(origins = "*")
public class SignupController {
    @Autowired
    SignupService signupService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public  ResponseEntity<?> signup(@RequestBody Users users) throws UserPrincipalNotFoundException {
        System.out.println("-------------------------------------------------------------------------------------");
        if (userService.findByUsername(users.getUsername())!=null){
            signupService.addUser(users);
        }
        else throw new UserPrincipalNotFoundException("Użytkownik o podanym loginie lub e-mailu już istnieje");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
