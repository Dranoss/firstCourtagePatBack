package com.patrimoine.website.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Entity
 public class User {

    @Id
   // @GeneratedValue= (GenerationType.AUTO)
    private Long id;
    private int phoneNumber;
    private int siretNumber;
    private String firstName="";
    private String lastName="";
    private String email="";
    private String password="";
    private String companyName="";
    private String role="";


    @OneToMany(mappedBy = "user")
    private List<BankAccount> bankAccounts ;


    @OneToMany (mappedBy = "user")
    private List<Address> addresses;

    public User(){
    }

    public Long getId() {
        return id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getSiretNumber() {
        return siretNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRole() {
        return role;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSiretNumber(int siretNumber) {
        this.siretNumber = siretNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", siretNumber=" + siretNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", companyName='" + companyName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


}
