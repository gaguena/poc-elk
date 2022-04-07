package com.gaguena.pocelk.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaguena.pocelk.model.User;
import com.gaguena.pocelk.repositoy.UserRepository;

@Service
public class UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByEmail(final String email) {
        LOGGER.info("Find User by e-mail: " + email);
        return this.userRepository.findByEmail(email).stream().findFirst();
    }
}
