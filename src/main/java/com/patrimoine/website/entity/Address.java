package com.patrimoine.website.entity;


import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberAddress;
    private int zipCode;
    private String street = "";
    private String city = "";

    @ManyToOne()
    @JoinColumn(name="address_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }



    public int getNumberAddress() {
        return numberAddress;
    }

    public void setNumberAddress(int numberAdress) {
        this.numberAddress = numberAdress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
