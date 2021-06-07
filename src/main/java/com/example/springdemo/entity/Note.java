package com.example.springdemo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "context")
    private String context;

    @Column(name = "importance")
    private Integer importance;

    @Column(name = "date")
    private LocalDateTime created;

    @ManyToOne()
    @JoinColumn(name="user_id", updatable = false)
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note() {
        this.created = LocalDateTime.now();
    }


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

    public Note(String title, String context, User user, Integer importance) {
        this.title = title;
        this.context = context;
        this.user = user;
        this.created = LocalDateTime.now();
        this.importance = importance;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }
}
