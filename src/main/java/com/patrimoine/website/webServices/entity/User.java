package com.patrimoine.website.webServices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PRIMARY KEY
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "userType")
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference(value = "userAddress")
    @JoinColumn(name = "user_address_id", referencedColumnName = "id")
    private UserAddress userAddress;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference(value = "userRib")
    @JoinColumn(name = "user_rib_id", referencedColumnName = "id")
    private UserRib userRib;

   /* @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference(value = "userProject")
    @JoinColumn(name = "project_id")
    private Project project;
    */
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String phoneNumber;
    private String companyName;
    private String siretNumber;
    private String sponsorshipCode;
    private String role;

    public Long getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }

    /*public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserRib getUserRib() {
        return userRib;
    }

    public void setUserRib(UserRib userRib) {
        this.userRib = userRib;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSiretNumber() {
        return siretNumber;
    }

    public void setSiretNumber(String siretNumber) {
        this.siretNumber = siretNumber;
    }

    public String getSponsorshipCode() {
        return sponsorshipCode;
    }

    public void setSponsorshipCode(String sponsorshipCode) {
        this.sponsorshipCode = sponsorshipCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
