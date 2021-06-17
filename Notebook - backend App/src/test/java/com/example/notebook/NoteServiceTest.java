package com.example.notebook;

import com.example.notebook.entity.Note;
import com.example.notebook.service.NoteService;
import com.example.notebook.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
public class NoteServiceTest {

    @Autowired
    NoteService noteService;

    @Autowired
   UserService userService;

    @BeforeEach
    public void creatingExampleNote() throws Exception{
        noteService.addNote(new Note("noteTestTitle","noteContext",userService.findByUsername("admin"),1));
    }

    @Test
    public void noteServiceLoads() throws Exception {
        assertThat(noteService).isNotNull();
    }


    @Test
    public void addNoteTest() throws Exception {
        assertThat(noteService.findByUserAndTitle(userService.findByUsername("admin"),"noteTestTitle").get()).isNotNull();

    }

    @AfterEach
    public void deletingExampleNote() throws Exception{
        noteService.deleteByUserAndTitle(userService.findByUsername("admin"),"noteTestTitle");    }
}
