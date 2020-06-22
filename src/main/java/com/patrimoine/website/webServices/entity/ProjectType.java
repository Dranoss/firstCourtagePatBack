package com.patrimoine.website.webServices.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProjectType {

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference(value = "projectType")
    private List<Project> projects;
    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference(value = "typeStatus")
    private List<ProjectStatus> projectStatuses;
    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference(value = "projectTypeDocument")
    private List<DocumentType> documentTypes;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<ProjectStatus> getProjectStatuses() {
        return projectStatuses;
    }

    public void setProjectStatuses(List<ProjectStatus> projectStatuses) {
        this.projectStatuses = projectStatuses;
    }

    public List<DocumentType> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(List<DocumentType> documentTypes) {
        this.documentTypes = documentTypes;
    }
}
