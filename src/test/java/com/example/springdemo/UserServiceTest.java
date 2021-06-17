package com.example.springdemo;

import com.example.springdemo.service.UserService;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void userServiceLoads() throws Exception {
        assertThat(userService).isNotNull();
    }
    @Test
    public void findByUsernameEqualsAdminTest(){
        assertThat(userService.findByUsername("admin")).isNotNull();
    }
    @Test
    public void userExistsTest(){
        assertTrue(userService.userExists(userService.findByUsername("admin").getUsername()));
    }

}
