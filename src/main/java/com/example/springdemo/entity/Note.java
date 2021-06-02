package com.example.springdemo.entity;

import javax.persistence.*;


@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "tytul")
    private String title;

    @Column(name = "tresc")
    private String context;

    @ManyToOne()
    @JoinColumn(name="user_id", updatable = false)
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note() { }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Note(String title, String context, User user) {
        this.title = title;
        this.context = context;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }
}
