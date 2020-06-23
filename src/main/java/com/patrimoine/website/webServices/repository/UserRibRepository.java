package com.patrimoine.website.webServices.repository;

import com.patrimoine.website.webServices.entity.UserRib;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRibRepository extends JpaRepository<UserRib, Long> {
}
