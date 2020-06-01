package com.patrimoine.website.services;


import com.patrimoine.website.entity.User;
import com.patrimoine.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getUsers() {

        try {
            return userRepo.selectUsers();
        } catch (
                SQLException throwables) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public  User getOneUser(int id){

        try {
            return  userRepo.selectUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }






}
