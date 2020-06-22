package com.patrimoine.website.webServices.service;


import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // GET ALL USERS
    public List<User> getAllUsers(){
        return userRepository.findAll();
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
    public User updateUser(User user, Long id){
        if(id == user.getId()){
            return userRepository.save(user);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    // DELETE USER
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
