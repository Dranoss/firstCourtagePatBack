package com.patrimoine.website.controller;



// controllers  mapping et responsebody pour les routes qui viennent de angular

import com.patrimoine.website.entity.User;
import com.patrimoine.website.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping()
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return  userService.getUsers();

    }
    @GetMapping("/user")
    public Optional<User> getUser(Long id){
      return    userService.getUser(id);
    }

    @PostMapping("/user")
    public User  addUser(User user) {

        return  userService.addUser(user);
    }


    /*@GetMapping("/userByName")
    public Optional<User> getUser(@RequestParam String name) {
            return null;
        }
*/

    @PostMapping("userdelete")
    public void  deleteUser(@RequestParam Long id) {

        userService.deleteUser(id);
    }



}


