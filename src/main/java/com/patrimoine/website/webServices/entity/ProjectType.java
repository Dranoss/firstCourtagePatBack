package com.patrimoine.website.webServices.entity;

import javax.persistence.*;

@Entity
public class ProjectType {

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Properties
    private String name;

    public ProjectType() {}

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
