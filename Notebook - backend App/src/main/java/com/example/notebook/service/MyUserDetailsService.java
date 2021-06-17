package com.example.notebook.service;

import com.example.notebook.entity.MyUserDetails;
import com.example.notebook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userService.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for "+ s + ".");
        }
        return new MyUserDetails(user);
    }
}
