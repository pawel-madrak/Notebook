package com.example.springdemo.controller;

import com.example.springdemo.entity.User;
import com.example.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("new-user") User user) {
        if (null != user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        return "redirect:/login";
    }

}
