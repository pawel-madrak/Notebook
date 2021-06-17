package com.example.notebook.repository;

import com.example.notebook.entity.Note;
import com.example.notebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {

    List<Note> findAllByUser(User user);
    Note findByUserAndId(User user, Integer id);
    Note findByUserAndTitle(User user, String title);
    List<Note> findAllByUserOrderByImportanceDesc(User user);
    List<Note> findAllByUserOrderByCreatedDesc(User user);
    List<Note> findAllByUserOrderByTitle(User user);
    void deleteByUserAndTitle(User user, String title);
}
