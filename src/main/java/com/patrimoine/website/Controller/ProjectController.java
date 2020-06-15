package com.patrimoine.website.Controller;

import com.patrimoine.website.Entity.Project;
import com.patrimoine.website.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/projects")
    public List<Project> getProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping(value = "/projects/{id}")
    public Project getProjectById(@PathVariable int id){
        return projectService.getProjectById(id);
    }

    @PostMapping(value = "/projects/add")
    public void addProject(Project project){
        projectService.saveProject(project);
    }

    @PutMapping(value = "/projects/edit")
    public void editProject(Project project){
        projectService.updateProject(project);
    }

    @DeleteMapping(value = "projects/delete")
    public void deleteProject(int id){
        projectService.deleteProject(id);
    }
}
