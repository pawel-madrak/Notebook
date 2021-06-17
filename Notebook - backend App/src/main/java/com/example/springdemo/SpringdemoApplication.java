package com.example.springdemo;
import com.example.springdemo.entity.User;
import com.example.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringdemoApplication {


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @PostConstruct

    public void init() {

        if (userService.findByUsername("admin") == null) {

            User admin = new User("admin", "admin@gmail.com", passwordEncoder.encode("admin1234"));
            List<User> users = Arrays.asList(admin);
            userService.saveAllUsers(users);

        }
    }
}
