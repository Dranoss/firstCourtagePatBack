package com.patrimoine.website.webServices.service;

import com.patrimoine.website.webServices.entity.Project;
import com.patrimoine.website.webServices.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id){
        Optional<Project> optionalProject = projectRepository.findById(id);
        if(optionalProject.isPresent()){
            return optionalProject.get();
        }
        return null;
    }

    public Project saveProject(Project project){
        return projectRepository.save(project);
    }

    public Project updateProject(Project project, Long id){
        return projectRepository.save(project);
    }

    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }


}
