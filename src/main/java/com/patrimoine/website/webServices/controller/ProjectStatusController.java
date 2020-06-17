package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.Project;
import com.patrimoine.website.webServices.entity.ProjectStatus;
import com.patrimoine.website.webServices.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/projectStatus")
@RestController
public class ProjectStatusController {

    @Autowired
    private ProjectStatusService projectStatusService;

    @GetMapping
    public List<ProjectStatus> getAll(){
        return projectStatusService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ProjectStatus getById(@PathVariable Long id){
        return projectStatusService.getById(id);
    }

    @PostMapping
    public ProjectStatus post(@RequestBody ProjectStatus projectStatus){
        return projectStatusService.post(projectStatus);
    }

    @PutMapping(value = "/{id}")
    public ProjectStatus put(@RequestBody ProjectStatus projectStatus, @PathVariable Long id){
        return projectStatusService.put(projectStatus, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        projectStatusService.delete(id);
    }
}
