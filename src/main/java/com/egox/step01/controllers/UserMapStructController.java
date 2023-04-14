package com.egox.step01.controllers;

import com.egox.step01.dtos.UserMsDto;
import com.egox.step01.exceptions.UserNotFoundException;
import com.egox.step01.mappers.UserMapper;
import com.egox.step01.models.User;
import com.egox.step01.services.UserService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<UserMsDto> getAllUserDtos(){
        List<User> users = userService.getAll();
        return userMapper.usersToUsersDto(users);
    }

    @GetMapping("/{id}")
    public UserMsDto getUserById(@PathVariable @Min(1) Long id){
        try {
            Optional<User> userOptional = userService.getById(id);
            User user = userOptional.get();
            return userMapper.userToUserDto(user);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
