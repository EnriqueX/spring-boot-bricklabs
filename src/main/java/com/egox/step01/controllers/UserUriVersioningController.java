package com.egox.step01.controllers;

import com.egox.step01.dtos.UserDtoV1;
import com.egox.step01.dtos.UserDtoV2;
import com.egox.step01.dtos.UserMmDto;
import com.egox.step01.exceptions.UserNotFoundException;
import com.egox.step01.models.User;
import com.egox.step01.services.UserService;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
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
@RequestMapping(value = "/versioning/uri/users")
public class UserUriVersioningController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping({"/v1.0/{id}", "/v1.1/{id}"})
    public UserDtoV1 getUserById(@PathVariable @Min(1) Long id){
        try {
            Optional<User> userOptional = userService.getById(id);
            User user = userOptional.get();
            UserDtoV1 userDto = modelMapper.map(user, UserDtoV1.class);
            return userDto;
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping({"/v2.0/{id}", })
    public UserDtoV2 getUserById2(@PathVariable @Min(1) Long id){
        try {
            Optional<User> userOptional = userService.getById(id);
            User user = userOptional.get();
            UserDtoV2 userDto = modelMapper.map(user, UserDtoV2.class);
            return userDto;
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
