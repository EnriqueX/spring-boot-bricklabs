package com.egox.step01.services;

import com.egox.step01.exceptions.OrderNotFoundException;
import com.egox.step01.models.Order;
import com.egox.step01.models.User;
import com.egox.step01.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(Order order){
        return orderRepository.save(order);
    }

    public Order getById(User userId, Long orderId) throws OrderNotFoundException {
        Order order = orderRepository.findByIdAndUser(orderId, userId);
        if(order == null){
            throw new OrderNotFoundException("Order not found");
        }
        return order;
    }
}
