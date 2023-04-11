package com.egox.step01.controllers;

import com.egox.step01.models.User;
import com.egox.step01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/users/{id}")
    public void updateUserById(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/users/byname/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.getByUsername(username);
    }
}
