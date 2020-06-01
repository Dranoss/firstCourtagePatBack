package com.patrimoine.website.entity;





 public class User {

    private int id;
    private int phoneNumber;
    private int siretNumber;
    private String firstName="";
    private String lastName="";
    private String email="";
    private String password="";
    private String companyName="";
    private String role="";

    private Address address;
    private BankAccount account ;
    private  Type typeUser;

    public User(){



    }

    public User(int id, int phoneNumber, int siretNumber,
                     String firstName, String lastName,
                     String email, String password,
                     String companyName, String role, Type type, Address address, BankAccount account) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.siretNumber = siretNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.role = role;

        this.account = account;
        this.address = address;

        if (type== null){
            System.out.println("creation du user ==> le type user n est pas défini");

        }
        else {
            this.typeUser = type;
        }
    }

    public int getId() {
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

    public void setId(int id) {
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
