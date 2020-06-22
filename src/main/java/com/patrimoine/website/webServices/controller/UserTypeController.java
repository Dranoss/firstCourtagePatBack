package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.entity.UserType;
import com.patrimoine.website.webServices.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(value = "/user_types")
@RestController
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @GetMapping
    public List<UserType> getAllUserTypes(){
        return userTypeService.getAllUserTypes();
    }

    @GetMapping(value = "/{id}")
    public UserType getUserTypeById(@PathVariable Long id){
        return userTypeService.getUserTypeById(id);
    }

    @PostMapping
    public UserType addUserType(@RequestBody UserType userType){
        return userTypeService.saveUserType(userType);
    }

    @PutMapping(value = "/{id}")
    public UserType putUserType(@PathVariable Long id, @RequestBody UserType userType){
        if(id == userType.getId()){
            return userTypeService.updateUserType(userType);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserTypeById(@PathVariable Long id){
        userTypeService.deleteUserTypeById(id);
    }
}
