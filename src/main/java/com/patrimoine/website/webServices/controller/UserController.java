package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // GET CURRENT USER (CONNEXION)
    @GetMapping("/me")
    public User getMe() {
        User user = userService.getMe();
        user.setProjects(new ArrayList<>());
        return user;
    }
    // GET ALL USERS
    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    public List<User> getAllUsers(){ return userService.getAllUsers(); }

    //GET USER BY ID
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    public User getUserById(@PathVariable Long id)  throws AccessDeniedException  {

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (  currentUser.getRole().equals("user")  &&  !currentUser.getId().equals(id)) {
            throw new AccessDeniedException("Vous n'êtes pas autorisé a accéder cette ressource");
        }
        return userService.getUserById(id);
    }

    // POST A NEW USER
    @PostMapping("/sign-up")
    @PreAuthorize("hasAuthority('admin')")
    public User postUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    // UPDATE USER
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public User putUser(@PathVariable Long id,@RequestBody User user){
        return userService.updateUser(user, id);
    }

    // CREATE USER PROJECT
    @PutMapping(value = "/{id}/create-project")
    @PreAuthorize("hasAuthority('admin')")
    public User createUserProject(@PathVariable Long id,@RequestBody User user){
        return userService.createUserProject(user, id);
    }

    // DELETE USER{
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('admin')")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
