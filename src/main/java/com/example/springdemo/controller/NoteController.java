package com.example.springdemo.controller;
import com.example.springdemo.entity.MyUserDetails;
import com.example.springdemo.entity.Note;
import com.example.springdemo.entity.User;
import com.example.springdemo.repository.NoteRepository;
import com.example.springdemo.repository.UserRepository;
import com.example.springdemo.service.NoteService;
import com.example.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class NoteController {

@Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteService noteService;


    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getNotes(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        model.addAttribute("noteList", noteService.getUserNotes(user));
        return "index";
    }
    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("note") Note note, Authentication authentication) {
        if (null != note) {
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            User user = myUserDetails.getUser();
            note.setUser(user);
            noteService.addNote(note);
        }
        return "redirect:/notes";
    }
    @DeleteMapping("/notes/{id}")
    public String deleteBook(@PathVariable Integer id, @ModelAttribute("model") ModelMap model, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        noteService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        noteService.deleteById(id);
        model.addAttribute("noteList", noteService.getUserNotes(user));
        return "index";
    }


    @RequestMapping(value = "/notes/{id}", method = RequestMethod.PUT)
    public String updateNote(@PathVariable Integer id, @RequestParam("title") String title, @RequestParam("edtContext") String context, @ModelAttribute("model") ModelMap model, Authentication authentication){
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        noteService.updateNote(id, title, context);
        model.addAttribute("noteList", noteService.getUserNotes(user));
        return "index";
    }
}
