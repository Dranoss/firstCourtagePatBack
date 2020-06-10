package com.patrimoine.website.services;

import com.patrimoine.website.entity.User;
import com.patrimoine.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


    public List<User> getUsers() {
        return  userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return  userRepository.findById(id);
    }
    public User  addUser(@RequestBody User user)
    {
        return  userRepository.save(user);
    }
    public void  deleteUser(@RequestParam Long id) {

        userRepository.deleteById(id);
    }

}
