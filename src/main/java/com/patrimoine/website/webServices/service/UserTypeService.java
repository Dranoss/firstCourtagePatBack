package com.patrimoine.website.webServices.service;

import com.patrimoine.website.webServices.entity.UserType;
import com.patrimoine.website.webServices.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    public List<UserType> getAllUserTypes(){
        return userTypeRepository.findAll();
    }

    public UserType getUserTypeById(Long id){
        Optional<UserType> userType = userTypeRepository.findById(id);
        if(userType.isPresent()){
            return userType.get();
        }
        return null;
    }

    public UserType saveUserType(UserType userType){
        return userTypeRepository.save(userType);
    }

    public UserType updateUserType(UserType userType){
        return userTypeRepository.save(userType);
    }

    public void deleteUserTypeById(Long id){
        userTypeRepository.deleteById(id);
    }


}
