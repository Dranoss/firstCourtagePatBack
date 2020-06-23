package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.ProjectType;
import com.patrimoine.website.webServices.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "/projectTypes")
@RestController
public class ProjectTypeController {

    @Autowired
    private ProjectTypeService projectTypeService;

    @GetMapping
    public List<ProjectType> getProjectTypes(){
        return projectTypeService.getAllProjectType();
    }

    @GetMapping(value = "/{id}")
    public ProjectType getProjectTypeById(@PathVariable Long id){
        return projectTypeService.getProjectTypeById(id);
    }

    @PostMapping
    public ProjectType postProjectType(@RequestBody ProjectType projectType){
        return projectTypeService.createProjectType(projectType);
    }

    @PutMapping(value = "/{id}")
    public ProjectType putProjectType(@RequestBody ProjectType projectType, @PathVariable Long id){
        return projectTypeService.updateProjectType(projectType, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProjectType(@PathVariable Long id){
        projectTypeService.deleteProjectType(id);
    }
}
