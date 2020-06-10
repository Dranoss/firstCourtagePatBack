package com.patrimoine.website.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeUser {

MNDS,CDSCK,DSC
    @Id
//    @GeneratedValue= (GenerationType.IDENTITY)
    private  Long id;
    private  String name;

    public TypeUser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
