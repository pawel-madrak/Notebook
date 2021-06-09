package com.example.springdemo.service;

import com.example.springdemo.entity.Note;
import com.example.springdemo.entity.User;
import com.example.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void updateUser(String username, String email, String password){
        User userToUpdate = userRepository.findByUsername(username);
        userToUpdate.setEmail(email);
        userToUpdate.setPassword(password);
        userRepository.save(userToUpdate);
    }

    public List<User> findAllByUsername(String username){
        return userRepository.findAllByUsername(username);
    }
}
