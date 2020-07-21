package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.Project;
import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping(value = "/projects")
@RestController
@PreAuthorize("hasAuthority('admin')")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getProjects(){
        return projectService.getAllProjects();
    }


    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('user') ")
    public Project getProjectById(@PathVariable Long id) throws AccessDeniedException {

        User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Project project =projectService.getProjectById(id);

        if (currentUser.getRole().equals("user") && !project.getUser().getId().equals(currentUser.getId())) {
                throw new AccessDeniedException("Vous n'êtes pas autorisé a accéder cette ressource");
        }
        return project;
    }


    @PostMapping
    public Project postProject(@RequestBody Project project){
        return projectService.saveProject(project);
    }

    @PutMapping(value = "/{id}")
    public Project putProject(@RequestBody Project project, @PathVariable Long id){
        return projectService.updateProject(project, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }
}
