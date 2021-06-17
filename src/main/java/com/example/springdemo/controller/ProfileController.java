package com.example.springdemo.controller;

import com.example.springdemo.entity.MyUserDetails;
import com.example.springdemo.entity.User;
import com.example.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getNotes(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        model.addAttribute("user", userService.findAllByUsername(user.getUsername()));
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.PUT)
    public String updateNote( @RequestParam("email") @Valid String email, @RequestParam("password") @Valid String password, @ModelAttribute("model") ModelMap model, Authentication authentication){
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        if (password != null && !password.isEmpty()) {
            userService.updateUser( user.getUsername(),email, passwordEncoder.encode(password));
        }
        model.addAttribute("user", userService.findAllByUsername(user.getUsername()));
        return "profile";
    }
}
