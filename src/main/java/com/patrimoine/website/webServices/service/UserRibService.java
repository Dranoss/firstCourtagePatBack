package com.patrimoine.website.webServices.service;

import com.patrimoine.website.webServices.entity.UserRib;
import com.patrimoine.website.webServices.repository.UserRibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRibService {

    @Autowired
    private UserRibRepository userRibRepository;

    public List<UserRib> getAllUserRibs(){
        return userRibRepository.findAll();
    }

    public UserRib getUserRibById(Long id){
        Optional<UserRib> optionalUserRib = userRibRepository.findById(id);
        if(optionalUserRib.isPresent()){
            return optionalUserRib.get();
        }
        return null;
    }

    public UserRib saveUserRib(UserRib userRib){
        return userRibRepository.save(userRib);
    }

    public UserRib updateUserRib(UserRib userRib){
        return userRibRepository.save(userRib);
    }

    public void deleteUserRib(Long id){
        userRibRepository.deleteById(id);
    }


}
