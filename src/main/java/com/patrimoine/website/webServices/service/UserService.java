package com.patrimoine.website.webServices.service;


import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // GET CURRENT USER (CONNEXION)
    public User getMe() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }
    // GET ALL USERS
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // GET USER BY HIS ID
    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }

    // CREATE USER
    public User saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // UPDATE USER
    public User updateUser(User user, Long id){
        if(id == user.getId()) {
            User userUpdated = userRepository.findById(id).get();
            userUpdated.setLastName(user.getLastName());
            userUpdated.setUserType(user.getUserType());
            userUpdated.setFirstName(user.getFirstName());
            userUpdated.setCompanyName(user.getCompanyName());
            userUpdated.setEmail(user.getEmail());
            userUpdated.setPhoneNumber(user.getPhoneNumber());
            userUpdated.setSponsorshipCode(user.getSponsorshipCode());
            return userRepository.save(userUpdated);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }
    // CREATE PROJECT ON USER
    public User createUserProject (User user, Long id){
        if(id == user.getId()) {
            User userUpdated = userRepository.findById(id).get();
            userUpdated.getProjects().add(user.getProjects().get(0));
            return userRepository.save(userUpdated);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_MODIFIED);
    }
    // DELETE USER
    public void  deleteUserById(Long id){
         userRepository.deleteById(id);
    }
}
