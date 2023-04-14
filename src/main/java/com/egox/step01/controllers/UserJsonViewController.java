package com.egox.step01.controllers;

import com.egox.step01.exceptions.UserNotFoundException;
import com.egox.step01.models.User;
import com.egox.step01.models.Views;
import com.egox.step01.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/jsonview/users")
public class UserJsonViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/external/{id}")
    @JsonView(Views.External.class)
    public Optional<User> getUserById(@PathVariable @Min(1) Long id){
        try {
            return userService.getById(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/internal/{id}")
    @JsonView(Views.Internal.class)
    public Optional<User> getUserById2(@PathVariable @Min(1) Long id){
        try {
            return userService.getById(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
