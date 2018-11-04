package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@CrossOrigin(origins = "*")
@RestController
public class PayController {

    @RequestMapping(value = "/pay/auth", method = RequestMethod.POST)
    public ResponseEntity<?> payAuth() {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
