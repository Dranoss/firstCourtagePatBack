package com.patrimoine.website.webServices.service;


import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // GET ALL USERS
    List<User> userList = new ArrayList<>();
    public List<User> getAllUsers(){
        userRepository.findAll();
        return userList;
    }

    // GET USER BY HIS ID
    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        return null;
    }

    // CREATE USER
    public User saveUser(User user){
        return userRepository.save(user);
    }

    // UPDATE USER
    public User updateUser(User user){
        return userRepository.save(user);
    }

    // DELETE USER
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
