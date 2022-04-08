package com.gaguena.pocelk.rest.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaguena.pocelk.data.UserData;
import com.gaguena.pocelk.facade.UserFacade;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @PostMapping(path = "/login")
    public ResponseEntity<? extends Serializable> login(final UserData user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userFacade.login(user));
    }

    @PostMapping(path = "/")
    public ResponseEntity<? extends Serializable> create(final UserData user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userFacade.create(user));
    }
}
