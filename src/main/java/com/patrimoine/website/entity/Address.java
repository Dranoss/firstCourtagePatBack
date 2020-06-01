package com.patrimoine.website.entity;



public class Address {


    private int id;
    private int numberAdress;
    private int zipCode;
    private String street = "";
    private String city = "";





    public Address() {
    }

    public Address(int id, int numberAdress, int zipCode, String street, String city) {
        this.id = id;
        this.numberAdress = numberAdress;
        this.zipCode = zipCode;
        this.street = street;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    /*  id en auto increment
    public void setId(int id) {
        this.id = id;
    }*/


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
