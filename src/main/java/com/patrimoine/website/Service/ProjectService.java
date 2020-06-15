package com.patrimoine.website.Service;

import com.patrimoine.website.Entity.Project;
import com.patrimoine.website.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects(){
        List<Project> projectList = new ArrayList<>();
        projectRepository.findAll().forEach(projectList::add);
        return projectList;
    }

    public Project getProjectById(int id){
        Optional<Project> optionalProject = projectRepository.findById(id);
        if(optionalProject.isPresent()){
            return optionalProject.get();
        }
        return null;
    }

    public void saveProject(Project project){
        projectRepository.save(project);
    }

    public void updateProject(Project project){
        projectRepository.save(project);
    }

    public void deleteProject(int id){
        projectRepository.deleteById(id);
    }


}
