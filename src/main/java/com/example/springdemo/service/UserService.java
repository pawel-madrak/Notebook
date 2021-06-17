package com.example.springdemo.service;
import com.example.springdemo.entity.User;
import com.example.springdemo.exceptions.UserAlreadyExistException;
import com.example.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public void saveUser(User user) throws UserAlreadyExistException {
        if (userExists(user.getUsername()))  {
            throw new UserAlreadyExistException("There is an account with that username: "
                    + user.getUsername());
        }
        userRepository.save(user);
    }
    public void saveAllUsers(List<User> users) throws UserAlreadyExistException {

        users.forEach(user ->  {
        if (userExists(user.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: "
                    + user.getUsername());
        }});
        userRepository.saveAll(users);
    }
    private boolean userExists(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
