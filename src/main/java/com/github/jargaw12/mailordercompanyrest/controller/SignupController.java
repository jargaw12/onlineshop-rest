package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.service.SignupService;
import com.github.jargaw12.mailordercompanyrest.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@CrossOrigin(origins = "*")
public class SignupController {
    @Autowired
    SignupService signupService;


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@Valid @RequestBody Users users, Errors errors) throws UserPrincipalNotFoundException {
        if (errors.hasErrors()){
            //TODO
        }
        if (!signupService.findUser(users.getEmailaddress())){
            signupService.addUser(users);
        }
        else throw new UserPrincipalNotFoundException("Użytkownik o podanym loginie lub e-mailu już istnieje");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}