package com.patrimoine.website.webServices.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PRIMARY KEY
    @Column(name = "user_id")
    private Long id;
    // FOREIGN KEYS
    // TO DO OneToMany and ManyToMany
    // PROPERTIES
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "siret_number")
    private String siretNumber;
    @Column(name = "sponsorship_code")
    private String sponsorshipCode;
    @Column(name = "role")
    private String role;


    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }

    public void setSponsorshipCode(String sponsorshipCode) {
        this.sponsorshipCode = sponsorshipCode;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSiretNumber() {
        return siretNumber;
    }

    public String getSponsorshipCode() {
        return sponsorshipCode;
    }

    public String getRole() {
        return role;
    }
}
