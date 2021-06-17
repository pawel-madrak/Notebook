package com.example.notebook.controller;
import com.example.notebook.entity.User;
import com.example.notebook.exceptions.UserAlreadyExistException;
import com.example.notebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("new-user") @Valid User user) {
       try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
        } catch (UserAlreadyExistException uaeEx) {
           System.out.println(uaeEx);
       }
        return "redirect:/login";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView forwardToLogin(){
        return new ModelAndView("redirect:/login");
    }

}
