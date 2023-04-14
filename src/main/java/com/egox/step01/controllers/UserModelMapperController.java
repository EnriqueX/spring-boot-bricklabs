package com.egox.step01.controllers;

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
@RequestMapping(value = "/modelmapper/users")
public class UserModelMapperController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public UserMmDto getUserById(@PathVariable @Min(1) Long id){
        try {
            Optional<User> userOptional = userService.getById(id);
            User user = userOptional.get();
            UserMmDto userDto = modelMapper.map(user, UserMmDto.class);
            return userDto;
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
