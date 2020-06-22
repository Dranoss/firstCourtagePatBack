package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.UserRib;
import com.patrimoine.website.webServices.entity.UserType;
import com.patrimoine.website.webServices.service.UserRibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(value = "/user_ribs")
@RestController
public class UserRibController {

    @Autowired
    private UserRibService userRibService;

    @GetMapping
    public List<UserRib> getAllUserRibs(){
        return userRibService.getAllUserRibs();
    }

    @GetMapping(value = "/{id}")
    public UserRib getUserRibById(@PathVariable Long id){
        return userRibService.getUserRibById(id);
    }

    @PostMapping
    public UserRib addUserRib(@RequestBody UserRib userRib){
        return userRibService.saveUserRib(userRib);
    }

    @PutMapping(value = "/{id}")
    public UserRib putUserRib(@PathVariable Long id, @RequestBody UserRib userRib){
        if(id == userRib.getId()){
            return userRibService.updateUserRib(userRib);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserRib(@PathVariable Long id){
        userRibService.deleteUserRib(id);
    }
}
