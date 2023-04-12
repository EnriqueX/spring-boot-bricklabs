package com.egox.step01.services;

import com.egox.step01.exceptions.UserExistsException;
import com.egox.step01.exceptions.UserNotFoundException;
import com.egox.step01.exceptions.UsernameNotFoundException;
import com.egox.step01.models.User;
import com.egox.step01.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User create(User user) throws UserExistsException{
        User currentlyUser = userRepository.findByUsername(user.getUsername());
        if(currentlyUser != null){
            throw new UserExistsException("User with the same username already exists");
        }
        user = userRepository.save(user);
        return user;
    }

    public Optional<User> getById(Long id) throws UserNotFoundException{
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public User update(User user) throws UserNotFoundException{
        Optional<User> oldUser = userRepository.findById(user.getId());
        if(!oldUser.isPresent()){
            throw new UserNotFoundException("User not exist. Please validate");
        }
        return userRepository.save(user);
    }

    public void delete(Long id) throws UserNotFoundException{
        Optional<User> oldUser = userRepository.findById(id);
        if(!oldUser.isPresent()){
            throw new UserNotFoundException("User ID not exist. Please validate");
        }
        userRepository.deleteById(id);
    }

    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
