package com.gaguena.pocelk.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaguena.pocelk.data.UserData;
import com.gaguena.pocelk.exception.InvalidArgumentException;
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

    public User create(final UserData data) {
        this.findByEmail(data.getUserName()).ifPresent(user -> {
            throw new InvalidArgumentException("Invalid data for e-mail: " + data.getUserName());
        });
        return this.userRepository.save(User.create(data));
    }
}
