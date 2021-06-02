package com.example.springdemo.service;


import com.example.springdemo.entity.Note;

import com.example.springdemo.entity.User;
import com.example.springdemo.repository.NoteRepository;
import com.example.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteRepository noteRepository;

    public List<Note> getNotes() {

        return noteRepository.findAll();
  }

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

    public List<Note> getUserNotes(User user) {
       return noteRepository.findAllByUser(user);
    }

}
