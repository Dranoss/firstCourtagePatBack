package com.patrimoine.website.entity;


import javax.persistence.*;

@Entity
public class Address {

    @Id
//    @GeneratedValue= (GenerationType.AUTO)
    private Long id;
    private int numberAdress;
    private int zipCode;
    private String street = "";
    private String city = "";

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;



    public Address() {
    }

    public Long getId() {
        return id;
    }



    public int getNumberAdress() {
        return numberAdress;
    }

    public void setNumberAdress(int numberAdress) {
        this.numberAdress = numberAdress;
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
