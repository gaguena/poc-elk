package com.gaguena.pocelk.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaguena.pocelk.data.TokenData;
import com.gaguena.pocelk.data.UserData;
import com.gaguena.pocelk.service.TokenService;
import com.gaguena.pocelk.service.UserService;

@Component
public class UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    public Optional<TokenData> login(final UserData data) {
        this.userService.findByEmail(data.getUserName()).map(user -> {
           this.tokenService.findActiveByEmail(user.getEmail()) 
        });
    }
}
