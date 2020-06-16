package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.Project;
import com.patrimoine.website.webServices.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/projects")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping(value = "/{id}")
    public Project getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id);
    }

    @PostMapping
    public void addProject(@RequestBody Project project){
        projectService.saveProject(project);
    }

    @PutMapping
    public void editProject(@RequestBody Project project){
        projectService.updateProject(project);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }
}
