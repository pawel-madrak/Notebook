package com.example.springdemo.service;


import com.example.springdemo.entity.Note;

import com.example.springdemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {


    @Autowired
    NoteRepository noteRepository;

    public List<Note> printNotes() {

        return noteRepository.findAll();
  }

    public void createAndAddNote(String title, String content){
        noteRepository.save(new Note(title,content));

    }
    public void updateNote(Integer id, String title, String content){

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
}
