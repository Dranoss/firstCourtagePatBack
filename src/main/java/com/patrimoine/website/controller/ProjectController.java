package com.patrimoine.website.controller;


import com.patrimoine.website.entity.Project;
import com.patrimoine.website.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> getAll(){
        return projectService.getProjects();

    }

    @GetMapping("/project")
    public Optional<Project> getProject(@RequestParam long id){
        return projectService.getProject(id);
    }





    @GetMapping("/projectsByType")
    public List<Project>  getAllByTypeProject(String type){

        return projectService.getProjectsByTypeProject(type);
    }

    @GetMapping("/projectsByName")
    public List<Project>  getAllByName(String name){

        return projectService.getProjectsByName(name);
    }


     @PostMapping("")
     public Project addProject(Project project){
       return   projectService.addProject(project);
     }


}
