package com.egox.step01.services;

import com.egox.step01.models.User;
import com.egox.step01.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User create(User user){
        user = userRepository.save(user);
        return user;
    }

    public User getById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User update(User user){
        user = userRepository.save(user);
        return user;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
