package com.patrimoine.website.controller;



// controllers  mapping et responsebody pour les routes qui viennent de angular

import com.patrimoine.website.entity.User;
import com.patrimoine.website.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> getUsers() {

    return  userService.getUsers();

    }


/*

    @PostMapping("/oneUser")
    public  User getOneUser(@RequestParam int id){
        return userService.getOneUser(id);
    }
*/



}


