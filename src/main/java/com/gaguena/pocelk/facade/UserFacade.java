package com.gaguena.pocelk.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaguena.pocelk.data.TokenData;
import com.gaguena.pocelk.data.UserData;
import com.gaguena.pocelk.exception.NotFoundException;
import com.gaguena.pocelk.model.Token;
import com.gaguena.pocelk.model.User;
import com.gaguena.pocelk.service.TokenService;
import com.gaguena.pocelk.service.UserService;

@Component
public class UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    public TokenData login(final UserData data) {
      return this.userService.findByEmail(data.getUserName())
        .map(user -> this.tokenService.findActiveByEmail(user.getEmail())
            .map(TokenData::create)
            .orElse(this.tokenCreate(user))
        ).orElseThrow(NotFoundException::new);
    }

    public TokenData create(final UserData data) {
      final User user = this.userService.create(data);
      return this.tokenCreate(user);
    }

    private TokenData tokenCreate(final User user) {
      final Token token = this.tokenService.create(user);
      return TokenData.create(token);
    }
}
