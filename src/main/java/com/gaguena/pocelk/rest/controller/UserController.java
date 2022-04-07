package com.gaguena.pocelk.rest.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaguena.pocelk.data.UserData;
import com.gaguena.pocelk.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<? extends Serializable> login(final UserData user) {
        this.userService.login(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
