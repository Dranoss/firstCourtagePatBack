package com.patrimoine.website.repository;


import com.patrimoine.website.entity.Project;
import com.patrimoine.website.entity.User;
import com.patrimoine.website.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {


        public List<Project> findProjectsByTypeProject(String type);
        public List<Project> findProjectsByName(String name);




}
