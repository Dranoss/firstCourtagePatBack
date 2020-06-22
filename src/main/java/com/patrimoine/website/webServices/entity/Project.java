package com.patrimoine.website.webServices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Project {

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "projectType")
    @JoinColumn(name = "type_id")
    private ProjectType projectType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "projectStatus")
    @JoinColumn(name = "status_id")
    private ProjectStatus projectStatus;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "projectDocument")
    private List<Document> documents;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JsonBackReference(value = "userProject")
    //private User user;
    //Properties
    private String name;
    private Long amount;
    private Date creationDate;
    private Date closingDate;

    public Project(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String projectName) {
        this.name = projectName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long projectAmount) {
        this.amount = projectAmount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    //public User getUser() {
      //  return user;
    //}

    //public void setUser(User user) {
      //  this.user = user;
    //}
}
