package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.Document;
import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.entity.UserAddress;
import com.patrimoine.website.webServices.service.UserAddressService;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user-addresses")
@RestController
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    public List<UserAddress> getAllUserAddresses(){
        return userAddressService.getAllUserAddresses();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    public UserAddress getUserAddressById(@PathVariable Long id){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (  currentUser.getRole().equals("user")  &&  !currentUser.getUserAddress().getId().equals(id)) {
            throw new AccessDeniedException("Vous n'êtes pas autorisé a accéder cette ressource");
        }
        return userAddressService.getUserAddressById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public UserAddress addUserAddress(@RequestBody UserAddress userAddress){
        return userAddressService.saveUserAddress(userAddress);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public UserAddress putUserAddress(@PathVariable Long id, @RequestBody UserAddress userAddress){
        return userAddressService.updateUserAddress(userAddress, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('admin')")
    public void deleteUserAddress(@PathVariable Long id){
        userAddressService.deleteUserAddress(id);
    }
}
