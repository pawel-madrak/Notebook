package com.example.springdemo.controller;

import com.example.springdemo.entity.MyUserDetails;
import com.example.springdemo.entity.Note;
import com.example.springdemo.entity.User;
import com.example.springdemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    NoteService noteService;

    @RequestMapping(value = "/api/notes", method = RequestMethod.GET)
    public List<Note> getUserNotes(Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        return noteService.getUserNotes(user);
    }

    @RequestMapping( value = "/api/notes/{id}", method = RequestMethod.GET)
    public Note getUserNote(@PathVariable Integer id, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        return noteService.findByUserAndId(user,id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
    }

}
