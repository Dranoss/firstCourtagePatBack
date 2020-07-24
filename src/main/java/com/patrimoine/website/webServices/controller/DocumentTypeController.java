package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.webServices.entity.DocumentType;
import com.patrimoine.website.webServices.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/document-types")
@RestController
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @GetMapping
    public List<DocumentType> getAll(){
        return documentTypeService.getAll();
    }

    @GetMapping(value = "/{id}")
    public DocumentType getById(@PathVariable Long id){
        return documentTypeService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public DocumentType post(@RequestBody DocumentType documentType){
        return documentTypeService.create(documentType);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public DocumentType put(@RequestBody DocumentType documentType, @PathVariable Long id){
        return documentTypeService.update(documentType, id);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin')" )
    public void delete(@PathVariable Long id){
        documentTypeService.delete(id);
    }
}
