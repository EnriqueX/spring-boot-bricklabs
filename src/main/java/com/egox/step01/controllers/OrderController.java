package com.egox.step01.controllers;

import com.egox.step01.exceptions.OrderNotFoundException;
import com.egox.step01.exceptions.UserNotFoundException;
import com.egox.step01.models.Order;
import com.egox.step01.models.User;
import com.egox.step01.services.OrderService;
import com.egox.step01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}/orders")
    public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userService.getById(userId);
        return userOptional.get().getOrders();
    }

    @PostMapping("/{userId}/orders")
    public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException {
        Optional<User> userOptional = userService.getById(userId);
        order.setUser(userOptional.get());
        return orderService.create(order);
    }

    @GetMapping("/{userId}/orders/{orderId}")
    public Order getOrderById(@PathVariable Long userId, @PathVariable Long orderId) throws UserNotFoundException, OrderNotFoundException {
        Optional<User> userOptional = userService.getById(userId);
        return orderService.getById(userOptional.get(), orderId);
    }
}
