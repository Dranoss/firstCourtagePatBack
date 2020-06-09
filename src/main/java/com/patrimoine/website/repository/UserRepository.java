package com.patrimoine.website.repository;

import com.patrimoine.website.entity.Address;
import com.patrimoine.website.entity.BankAccount;
import com.patrimoine.website.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public interface UserRepository   extends JpaRepository<User , Long >{
        }