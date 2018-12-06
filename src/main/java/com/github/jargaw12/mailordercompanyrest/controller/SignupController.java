package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
public class SignupController {
    private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signup(@Valid @RequestBody Users users, Errors errors) {
        if (!signupService.findUser(users.getUsername())) {
            signupService.addUser(users);
        } else throw new IllegalArgumentException("Użytkownik o podanym adresie e-mail: " + users.getUsername() + " już istnieje");
    }
}
