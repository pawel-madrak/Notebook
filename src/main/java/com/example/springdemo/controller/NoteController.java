package com.example.springdemo.controller;


import com.example.springdemo.entity.Note;
import com.example.springdemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    @Autowired
    NoteService noteService;


    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String printNotes(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("noteList", noteService.printNotes());
        return "index";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("note") Note note, ModelMap model) {
        if (null != note) {
            noteService.addNote(note);
            model.addAttribute("noteList", noteService.printNotes());
        }
        return "redirect:/notes";
    }
    @DeleteMapping("/notes/{id}")
    public String deleteBook(@PathVariable Integer id, ModelMap model) {
        noteService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        noteService.deleteById(id);
        model.addAttribute("noteList", noteService.printNotes());
        return "index";
    }



/*    @RequestMapping(value = "/notes", method = RequestMethod.DELETE)
    public void deleteNote(@RequestParam("id") Integer id){
       noteService.deleteNote(id);
    }*/
    /*@RequestMapping(value = "/notes", method = RequestMethod.POST)
    public void addNote(@RequestParam("title") String title, @RequestParam("content") String content){
        noteService.addNote(title, content);
    }*/
    @RequestMapping(value = "/notes", method = RequestMethod.PUT)
    public void updateNote(@RequestParam("id") Integer id, @RequestParam("title") String title, @RequestParam("content") String content){
        noteService.updateNote(id, title, content);
    }
}
