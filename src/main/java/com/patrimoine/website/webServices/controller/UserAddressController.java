package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.UserAddress;
import com.patrimoine.website.webServices.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(value = "/user-addresses")
@RestController
@CrossOrigin
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping
    public List<UserAddress> getAllUserAddresses(){
        return userAddressService.getAllUserAddresses();
    }

    @GetMapping(value = "/{id}")
    public UserAddress getUserAddressById(@PathVariable Long id){
        return userAddressService.getUserAddressById(id);
    }

    @PostMapping
    public UserAddress addUserAddress(@RequestBody UserAddress userAddress){
        return userAddressService.saveUserAddress(userAddress);
    }

    @PutMapping(value = "/{id}")
    public UserAddress putUserAddress(@PathVariable Long id, @RequestBody UserAddress userAddress){
        return userAddressService.updateUserAddress(userAddress, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserAddress(@PathVariable Long id){
        userAddressService.deleteUserAddress(id);
    }
}
