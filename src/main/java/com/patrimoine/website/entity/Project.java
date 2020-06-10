package com.patrimoine.website.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long amount;
    private Date dateOpened;
    private Date dateClosed;


    @ManyToOne
    @JoinColumn(name = "project_id")
    private User user ;

    @ManyToOne
    @JoinColumn(name = "typeProject_id")
    private TypeProject typeProject ;


    public TypeProject getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(TypeProject typeProject) {
        this.typeProject = typeProject;
    }

    public Project() {

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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
