package com.patrimoine.website.repository;

import com.patrimoine.website.entity.Address;
import com.patrimoine.website.entity.BankAccount;
import com.patrimoine.website.entity.User;
import com.patrimoine.website.services.ProjectService;
import com.patrimoine.website.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository   extends JpaRepository<User , Long > {

    User findUserByLastName(String name);
    User findUserByCompanyName(String companyName);
    User findUserByRole(String role);
    User findUserByPhoneNumber(int number);
    List<User> findAllByOrderByLastNameAsc();
    List<User> findAllByOrderByLastNameDesc();

}