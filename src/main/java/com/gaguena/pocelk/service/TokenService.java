package com.gaguena.pocelk.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaguena.pocelk.data.TokenData;
import com.gaguena.pocelk.model.Token;
import com.gaguena.pocelk.model.User;
import com.gaguena.pocelk.repositoy.TokenRepositoy;

@Service
public class TokenService {

    private static Logger LOGGER = LoggerFactory.getLogger(TokenService.class);

    @Autowired
    private TokenRepositoy tokenRepositoy;

    public Optional<Token> findActiveByEmail(final String email) {
        LOGGER.info("Filter token active by e-mail user");
        return this.tokenRepositoy.findActiveBy(email).stream()
                .findFirst();
    }

    public Token create(final User user) {
        final Token token = Token.create(user);
        return this.tokenRepositoy.save(token);
    }

}
