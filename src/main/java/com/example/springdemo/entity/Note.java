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

    public Note(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public Integer getId() {
        return id;
    }
}
