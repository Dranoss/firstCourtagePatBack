package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    // GET ALL USERS
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    //GET USER BY ID
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    // POST A NEW USER
    @PostMapping
    public User postUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    // UPDATE USER
    @PutMapping(value = "/{id}")
    public User putUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    // DELETE USER{
    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
