package com.patrimoine.website.services;


import com.patrimoine.website.entity.Project;
import com.patrimoine.website.entity.User;
import com.patrimoine.website.repository.ProjectRepository;
import com.patrimoine.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {



    @Autowired
    ProjectRepository projectRepository;


    public List<Project> getProjects()
    {
        return  projectRepository.findAll();
    }

    public Optional<Project> getProject(Long id) {

        return  projectRepository.findById(id);
    }

    public List<Project> getProjectsByTypeProject(String type) {

        return projectRepository.findProjectsByTypeProject(type);

    }

    public List<Project> getProjectsByName(String name) {

        return projectRepository.findProjectsByName(name);

    }
    public  Project addProject(Project project){
        return projectRepository.save(project);
    }



    public void  deleteProject(Long id) {

        projectRepository.deleteById(id);
    }




}
