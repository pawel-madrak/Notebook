package com.example.springdemo.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "username", nullable = false, unique = true)
    @NotEmpty
    @NotBlank(message = "Login cannot be empty")
    private String username;

    @Column(name = "email", nullable = false)
    @Email(message = "Email should be valid")
    @NotEmpty
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @NotBlank(message = "Password cannot be empty")
    private String password;


    protected User(){ }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
