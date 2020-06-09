package com.patrimoine.website.controller;



// controllers  mapping et responsebody pour les routes qui viennent de angular

import com.patrimoine.website.entity.User;
import com.patrimoine.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers() {
        return  userRepository.findAll();

    }

    @PostMapping("/addUsers")
    @ResponseBody
    public User  addUser(User user) {
        return         userRepository.save(user);
    }

    @GetMapping("/user")
    @ResponseBody
    public Optional<User> getUser(@RequestParam Long id) {
        return  userRepository.findById(id);
    }

    /*@GetMapping("/userByName")
    public Optional<User> getUser(@RequestParam String name) {
            return null;
        }
*/

    @PostMapping("users/delUser")
    public void  deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);
    }



}


