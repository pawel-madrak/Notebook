package com.example.springdemo;


import com.example.springdemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringdemoApplication {


    @Autowired
    NoteService noteService;

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @PostConstruct
    public void init() {



    }

}
