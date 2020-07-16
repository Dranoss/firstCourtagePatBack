package com.patrimoine.website.webServices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "documentType")
    @JoinColumn(name = "type_id")
    private DocumentType documentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "projectDocument")
    @JoinColumn(name = "project_id")
    private Project project;

    public Document() {
    }


    public Document(String name, String url) {
        this.name = name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        this.url = url;
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

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
