package com.egox.step01.controllers;

import com.egox.step01.exceptions.UserNotFoundException;
import com.egox.step01.models.Order;
import com.egox.step01.models.User;
import com.egox.step01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hateoas/users")
public class OrderHateoasController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/orders")
    public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userService.getById(userId);
        return userOptional.get().getOrders();
    }
}
