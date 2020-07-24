package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.entity.UserRib;
import com.patrimoine.website.webServices.entity.UserType;
import com.patrimoine.website.webServices.service.UserRibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(value = "/user-ribs")
@RestController
public class UserRibController {

    @Autowired
    private UserRibService userRibService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    public List<UserRib> getAllUserRibs(){
        return userRibService.getAllUserRibs();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    public UserRib getUserRibById(@PathVariable Long id){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (  currentUser.getRole().equals("user")  &&  !currentUser.getUserRib().getId().equals(id)) {
            throw new AccessDeniedException("Vous n'êtes pas autorisé a accéder cette ressource");
        }
        return userRibService.getUserRibById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public UserRib addUserRib(@RequestBody UserRib userRib){
        return userRibService.saveUserRib(userRib);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public UserRib putUserRib(@PathVariable Long id, @RequestBody UserRib userRib){
        if(id.equals(userRib.getId())){
            return userRibService.updateUserRib(userRib, id);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('admin')")
    public void deleteUserRib(@PathVariable Long id){
        userRibService.deleteUserRib(id);
    }
}
