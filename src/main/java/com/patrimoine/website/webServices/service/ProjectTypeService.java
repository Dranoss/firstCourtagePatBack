package com.patrimoine.website.webServices.service;

import com.patrimoine.website.webServices.entity.Project;
import com.patrimoine.website.webServices.entity.ProjectType;
import com.patrimoine.website.webServices.repository.ProjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeService {

    @Autowired
    ProjectTypeRepository projectTypeRepository;

    //GetAll
    public List<ProjectType> getAllProjectType(){
        return projectTypeRepository.findAll();
    }

    //GetById
    public ProjectType getProjectTypeById(Long id){
        Optional<ProjectType> optionalProjectType = projectTypeRepository.findById(id);
            if(optionalProjectType.isPresent()) {
            return optionalProjectType.get();
            }
        return null;
    }

    //Create
    public ProjectType createProjectType(ProjectType projectType){
        return projectTypeRepository.save(projectType);
    }

    //Update
    public ProjectType updateProjectType(ProjectType projectType, Long id){
        return projectTypeRepository.save(projectType);
    }

    //Delete
    public void deleteProjectType(Long id){
        projectTypeRepository.deleteById(id);
    }

}
