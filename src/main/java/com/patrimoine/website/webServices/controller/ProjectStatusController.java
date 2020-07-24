package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.Project;
import com.patrimoine.website.webServices.entity.ProjectStatus;
import com.patrimoine.website.webServices.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "/project-status")
@RestController
public class ProjectStatusController {

    @Autowired
    private ProjectStatusService projectStatusService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    public List<ProjectStatus> getAll(){
        return projectStatusService.getAll();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')" )
    public ProjectStatus getById(@PathVariable Long id){
        return projectStatusService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public ProjectStatus post(@RequestBody ProjectStatus projectStatus){
        return projectStatusService.post(projectStatus);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public ProjectStatus put(@RequestBody ProjectStatus projectStatus, @PathVariable Long id){
        return projectStatusService.put(projectStatus, id);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public void delete(@PathVariable Long id){
        projectStatusService.delete(id);
    }
}
