package com.patrimoine.website.webServices.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Properties
    private Long statusId;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_amount")
    private Long projectAmount;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "closing_date")
    private Date closingDate;

    public Project(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(Long projectAmount) {
        this.projectAmount = projectAmount;
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
}
