package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import com.example.demo.model.User;

import java.util.*;

@RequestMapping("/users")
@RestController
public class UserController {

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {

        User user1 = new User();
        user1.setName("user1");
        user1.setEmail("mail@test.com");

        User user2 = new User();
        user2.setName("user2");
        user2.setEmail("mail2@test.com");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        return ResponseEntity.ok(list);
    }

}

