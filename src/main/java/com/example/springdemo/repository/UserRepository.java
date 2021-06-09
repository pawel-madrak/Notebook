package com.example.springdemo.repository;
import com.example.springdemo.entity.Note;
import com.example.springdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);


    List<User> findAllByUsername(String username);
}
