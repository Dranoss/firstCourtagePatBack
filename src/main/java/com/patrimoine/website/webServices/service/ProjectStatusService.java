package com.patrimoine.website.webServices.service;

import com.patrimoine.website.webServices.entity.Project;
import com.patrimoine.website.webServices.entity.ProjectStatus;
import com.patrimoine.website.webServices.repository.ProjectStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectStatusService {

    @Autowired
    ProjectStatusRepository projectStatusRepository;

    //GetAll
    public List<ProjectStatus> getAll(){
        return projectStatusRepository.findAll();
    }

    //GetByID
    public ProjectStatus getById(Long id){
        Optional<ProjectStatus> optionalProjectStatus = projectStatusRepository.findById(id);
        if(optionalProjectStatus.isPresent()){
            return optionalProjectStatus.get();
        }
        return null;
    }

    //Create
    public ProjectStatus post(ProjectStatus projectStatus){
        return projectStatusRepository.save(projectStatus);
    }

    //Update
    public ProjectStatus put(ProjectStatus projectStatus, Long id){
        return projectStatusRepository.save(projectStatus);
    }

    //Delete
    public void delete(Long id){
        projectStatusRepository.deleteById(id);
    }
}
