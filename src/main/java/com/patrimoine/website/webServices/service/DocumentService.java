package com.patrimoine.website.webServices.service;

import com.patrimoine.website.webServices.entity.Document;
import com.patrimoine.website.webServices.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    //GetAll
    public List<Document> getAll(){
        return documentRepository.findAll();
    }

    //GetByID
    public Document getById(Long id){
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if(optionalDocument.isPresent()){
            return optionalDocument.get();
        }
        return null;
    }

    //Create
    public Document create(Document document){
        return documentRepository.save(document);
    }

    //Update
    public Document update(Document document, Long id){
        return documentRepository.save(document);
    }

    //Delete
    public void delete(Long id){
        documentRepository.deleteById(id);
    }
}
