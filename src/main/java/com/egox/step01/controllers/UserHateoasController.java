package com.egox.step01.controllers;

import com.egox.step01.exceptions.UserNotFoundException;
import com.egox.step01.models.User;
import com.egox.step01.services.OrderService;
import com.egox.step01.services.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/hateoas/users")
public class UserHateoasController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity getAllUsers(){
        List<User> users = userService.getAll();
        for (User u:users) {
            Link selfLink = linkTo(methodOn(UserHateoasController.class).getUserById(u.getId())).withSelfRel();
            u.add(selfLink);
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable @Min(1) Long id){
        try {
            Optional<User> userOptional = userService.getById(id);
            User user = userOptional.get();
            Link selfLink = linkTo(methodOn(UserHateoasController.class).getUserById(id)).withSelfRel();
            user.add(selfLink);
            return new ResponseEntity(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
