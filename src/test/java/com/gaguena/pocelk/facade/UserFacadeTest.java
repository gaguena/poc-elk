package com.gaguena.pocelk.facade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.gaguena.pocelk.service.UserService;

@SpringBootTest
class UserFacadeTest {

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Test login success")
    void login() {
    }

}
