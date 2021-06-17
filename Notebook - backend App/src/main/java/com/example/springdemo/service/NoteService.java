package com.example.springdemo.service;
import com.example.springdemo.entity.Note;
import com.example.springdemo.entity.User;
import com.example.springdemo.repository.NoteRepository;
import com.example.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteRepository noteRepository;


    public void updateNote(Integer id, String title, String context){
       Note noteToUpdate = noteRepository.findById(id).get();
       noteToUpdate.setTitle(title);
       noteToUpdate.setContext(context);
       noteRepository.save(noteToUpdate);
    }

    public void addNote(Note note) {
        noteRepository.save(note);
    }

    public Optional<Note> findById(Integer id) {
        return noteRepository.findById(id);
    }

    public void deleteById(Integer id) {
        noteRepository.deleteById(id);
    }

    public void deleteByUserAndTitle(User user, String title) {
        noteRepository.deleteByUserAndTitle(user, title);
    }

    public List<Note> findAllByUser(User user) {
       return noteRepository.findAllByUser(user);
    }

    public Optional<Note> findByUserAndId(User user, Integer id) {
        return Optional.ofNullable(noteRepository.findByUserAndId(user, id));
    }
    public Optional<Note> findByUserAndTitle(User user, String title){
        return Optional.ofNullable(noteRepository.findByUserAndTitle(user, title));
    }
    public List<Note> findAllByUserOrderByImportanceDesc(User user){
        return  noteRepository.findAllByUserOrderByImportanceDesc(user);
    }
    public List<Note> findAllByUserOrderByCreatedDesc(User user){
        return  noteRepository.findAllByUserOrderByCreatedDesc(user);
    }
    public List<Note> findAllByUserOrderByTitle(User user){
        return  noteRepository.findAllByUserOrderByTitle(user);
    }

    public void sortNotes(ModelMap model, String sorting, User user){
        switch(sorting) {
            case "alphabetical":
                model.addAttribute("noteList", findAllByUserOrderByTitle(user));
                break;
            case "byImportance":
                model.addAttribute("noteList", findAllByUserOrderByImportanceDesc(user));
                break;
            case "byDate":
                model.addAttribute("noteList", findAllByUserOrderByCreatedDesc(user));
                break;
        }
    }

}
