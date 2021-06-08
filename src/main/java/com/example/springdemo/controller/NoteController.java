package com.example.springdemo.controller;
import com.example.springdemo.entity.MyUserDetails;
import com.example.springdemo.entity.Note;
import com.example.springdemo.entity.User;
import com.example.springdemo.repository.UserRepository;
import com.example.springdemo.service.NoteService;
import com.example.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteService noteService;

    String orderBy = "";


    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getNotes(@ModelAttribute("model") ModelMap model, Authentication authentication,@RequestParam(name = "orderBy", defaultValue = "alphabetical") String sort) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        switch(sort) {
            case "alphabetical":
                model.addAttribute("noteList", noteService.findAllByUserOrderByTitle(user));
                break;
            case "byImportance":
                model.addAttribute("noteList", noteService.findAllByUserOrderByImportanceDesc(user));
                break;
            case "byDate":
                model.addAttribute("noteList", noteService.findAllByUserOrderByCreatedDesc(user));
                break;
        }
        orderBy = sort;
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
        return "redirect:/notes?orderBy=" + orderBy;
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
