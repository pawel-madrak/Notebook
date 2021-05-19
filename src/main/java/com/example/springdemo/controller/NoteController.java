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
    public String getNotes(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("noteList", noteService.getNotes());
        return "index";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNote(@ModelAttribute("note") Note note, ModelMap model) {
        if (null != note) {
            noteService.addNote(note);
            model.addAttribute("noteList", noteService.getNotes());
        }
        return "redirect:/notes";
    }
    @DeleteMapping("/notes/{id}")
    public String deleteBook(@PathVariable Integer id, ModelMap model) {
        noteService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        noteService.deleteById(id);
        model.addAttribute("noteList", noteService.getNotes());
        return "index";
    }


    @RequestMapping(value = "/notes/{id}", method = RequestMethod.PUT)
    public String updateNote(@PathVariable Integer id, @RequestParam("title") String title, @RequestParam("edtContext") String content, ModelMap model){
        noteService.updateNote(id, title, content);
        model.addAttribute("noteList", noteService.getNotes());
        return "index";
    }
}
