package com.patrimoine.website.webServices.entity;

import javax.persistence.*;

@Entity
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_type_id")
    private Long id;
    @Column(name = "user_type_name")
    private String name;
}
