package com.example.springdemo;


import com.example.springdemo.entity.Note;
import com.example.springdemo.entity.User;
import com.example.springdemo.repository.NoteRepository;
import com.example.springdemo.repository.UserRepository;
import com.example.springdemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringdemoApplication {


    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @PostConstruct

    public void init() {
        noteRepository.deleteAll();
        userRepository.deleteAll();
        User user = new User("user", "user@gmail.com", passwordEncoder.encode("user1234"));
        User admin = new User("admin", "admin@gmail.com", passwordEncoder.encode("admin1234"));
        Note userNote = new Note("usernote1","usernote1",user,2);
        Note adminNote = new Note("adminnote1","adminnote1",admin,1);
        Note adminNote2 = new Note("adminnote2","adminnote2",admin,2);
        Note adminNote3 = new Note("adminnote3","adminnote3",admin,3);

        List<User> users = Arrays.asList(user,admin);
        userRepository.saveAll(users);

        noteRepository.save(userNote);
        noteRepository.save(adminNote);
        noteRepository.save(adminNote2);
        noteRepository.save(adminNote3);




    }

}
