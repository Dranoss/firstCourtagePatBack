package com.patrimoine.website.webServices.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity

public class ProjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "projectType", fetch = FetchType.LAZY)
    @JsonIdentityInfo(
            scope = ProjectType.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<Project> projects;

    @OneToMany(mappedBy = "projectType",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "typeStatus")
    private List<ProjectStatus> projectStatuses;

    @OneToMany(mappedBy = "projectType",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "projectTypeDocument")
    private List<DocumentType> documentTypes;

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
