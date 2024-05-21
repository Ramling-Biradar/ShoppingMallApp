package com.project.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.User;
import com.project.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> listAllUsers() {
        return userService.listAll();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.get(id);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    public boolean logOut() {
        return userService.logOut();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existingUser = userService.get(id);
            if (existingUser != null) {
                // Update the fields of the existing user
                existingUser.setName(user.getName());
                existingUser.setType(user.getType());
                existingUser.setPassword(user.getPassword());
                // Save the updated user
                userService.updateUser(existingUser);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                // User with the specified ID not found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            // Handle exceptions if the user retrieval fails
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

