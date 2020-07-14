package com.patrimoine.website.webServices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProjectStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "projectStatus", fetch = FetchType.LAZY)
    @JsonIdentityInfo(
            scope = ProjectStatus.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<Project> projects;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "typeStatus")
    @JoinColumn(name = "type_id")
    private ProjectType projectType;

    private String name;
    private Long ranking;

    public ProjectStatus() {
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

    public Long getRanking() {
        return ranking;
    }

    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }
}
