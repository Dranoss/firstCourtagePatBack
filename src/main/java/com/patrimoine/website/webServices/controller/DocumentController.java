package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.Document;
import com.patrimoine.website.webServices.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/documents")
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Document> getAll(){
        return documentService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Document getById(@PathVariable Long id){
        return documentService.getById(id);
    }

    @PostMapping
    public Document post(Document document){
        return documentService.create(document);
    }

    @PutMapping(value = "/{id}")
    public Document put(Document document, Long id){
        return documentService.update(document, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(Long id){
        documentService.delete(id);
    }
}
