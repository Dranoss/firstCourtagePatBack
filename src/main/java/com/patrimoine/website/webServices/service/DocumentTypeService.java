package com.patrimoine.website.webServices.service;

import com.patrimoine.website.webServices.entity.Document;
import com.patrimoine.website.webServices.entity.DocumentType;
import com.patrimoine.website.webServices.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    //GetAll
    public List<DocumentType> getAll(){
        return documentTypeRepository.findAll();
    }

    //GetById
    public DocumentType getById(Long id){
        Optional<DocumentType> optionalDocumentType = documentTypeRepository.findById(id);
        if(optionalDocumentType.isPresent()){
            return optionalDocumentType.get();
        }
        return null;
    }

    //Create
    public DocumentType create(DocumentType documentType){
        return documentTypeRepository.save(documentType);
    }

    //Update
    public DocumentType update(DocumentType documentType, Long id){
        if(id == documentType.getId()){
            return documentTypeRepository.save(documentType);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    //Delete
    public void delete(Long id){
        documentTypeRepository.deleteById(id);
    }

}
