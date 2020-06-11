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

    @GetMapping("/usersAsc")
    public List<User> getUsersAsc() {
        return  userService.getUsersAsc();
    }

    @GetMapping("/usersDsc")
    public List<User> getUsersDsc() {
        return  userService.getUsersDsc();
    }
    @GetMapping("/user")
    public Optional<User> getUser(Long id){

        return    userService.getUser(id);
    }

    @GetMapping("/userByName")
    public Optional<User> getUserByName(String name){

        return    userService.getUserByName(name);
    }

    @GetMapping("/userByCompanyName")
    public Optional<User> getUserByCompanyName(String name){

        return    userService.getUserByCompanyName(name);
    }

    @GetMapping("/userByRole")
    public Optional<User> getUserByRole(String role){

        return    userService.getUserByRole(role);
    }

    @GetMapping("/userByPhoneNumber")
    public Optional<User> getUserByPhoneNumber(int number){

        return    userService.getUserByPhoneNumber(number);
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


