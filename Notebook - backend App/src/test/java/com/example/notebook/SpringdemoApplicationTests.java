package com.example.notebook;

import com.example.notebook.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringdemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void userServiceLoads() throws Exception {
        assertThat(userService).isNotNull();
    }
    @Test
    void passwordEncoderLoads() throws Exception {
        assertThat(passwordEncoder).isNotNull();
    }

}
