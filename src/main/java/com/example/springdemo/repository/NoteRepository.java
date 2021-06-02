package com.example.springdemo.repository;

import com.example.springdemo.entity.Note;
import com.example.springdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {

    List<Note> findAllByUser(User user);

    Note findNoteById(Integer id);

    Note findByUserAndId(User user, Integer id);
}
