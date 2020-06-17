package com.patrimoine.website.webServices.repository;

import com.patrimoine.website.webServices.entity.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {
}
