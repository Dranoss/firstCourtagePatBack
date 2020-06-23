package com.patrimoine.website.webServices.service;

import com.patrimoine.website.webServices.entity.UserAddress;
import com.patrimoine.website.webServices.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public List<UserAddress> getAllUserAddresses(){
        return userAddressRepository.findAll();
    }

    public UserAddress getUserAddressById(Long id){
        Optional<UserAddress> userAddress = userAddressRepository.findById(id);
        if(userAddress.isPresent()){
            return userAddress.get();
        }
        return null;
    }

    public UserAddress saveUserAddress(UserAddress userAddress){
        return userAddressRepository.save(userAddress);
    }

    public UserAddress updateUserAddress(UserAddress userAddress, Long id){
        if(id == userAddress.getId()) {
            return userAddressRepository.save(userAddress);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    public void deleteUserAddress(Long id){
        userAddressRepository.deleteById(id);
    }


}
