package com.example.notebook.controller;
import com.example.notebook.entity.MyUserDetails;
import com.example.notebook.entity.Note;
import com.example.notebook.entity.User;
import com.example.notebook.service.NoteService;
import com.example.notebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class NoteController {

    @Autowired
    UserService userService;

    @Autowired
    NoteService noteService;


    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getNotes(@ModelAttribute("model") ModelMap model, Authentication authentication,@RequestParam(name = "orderBy", defaultValue = "alphabetical") String sorting) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        noteService.sortNotes(model,sorting,user);
        return "index";
    }

    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("note") @Valid Note note, Authentication authentication) {
        if (null != note) {
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            User user = myUserDetails.getUser();
            note.setUser(user);
            noteService.addNote(note);
        }
        return "redirect:/notes";
    }
    @RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Integer id, @ModelAttribute("model") ModelMap model, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        noteService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        noteService.deleteById(id);
        model.addAttribute("noteList", noteService.findAllByUser(user));
        return "index";
    }


    @RequestMapping(value = "/notes/{id}", method = RequestMethod.PUT)
    public String updateNote(@PathVariable Integer id, @RequestParam("title") String title, @RequestParam("edtContext") String context, @ModelAttribute("model") ModelMap model, Authentication authentication){
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        noteService.updateNote(id, title, context);
        model.addAttribute("noteList", noteService.findAllByUser(user));
        return "index";
    }
}
