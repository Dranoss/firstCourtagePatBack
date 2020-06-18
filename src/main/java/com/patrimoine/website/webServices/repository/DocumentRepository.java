package com.patrimoine.website.webServices.repository;

import com.patrimoine.website.webServices.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
