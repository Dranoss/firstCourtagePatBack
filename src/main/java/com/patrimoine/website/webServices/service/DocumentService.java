package com.patrimoine.website.webServices.service;

import com.patrimoine.website.webServices.entity.Document;
import com.patrimoine.website.webServices.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Value("${base-url}")
    private String baseUrl;

    @Value("${root-folder}")
    private String rootFolder;


    @Autowired
    private DocumentRepository documentRepository;

    public void init() {
        if (!Files.exists(Paths.get(rootFolder))){
            try {
                Files.createDirectory(Paths.get(rootFolder));
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload!");
            }
        }
    }

    public Document save(MultipartFile file) {
        try {
            String randFileName = (new Date()).getTime() + file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            Path path = Paths.get(rootFolder+"/" + randFileName);
            Files.write(path, bytes);
            Document document1 = new Document(randFileName, baseUrl + "/" + randFileName);
            return documentRepository.save(document1);
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Resource load(String name) {
        try {
            Path root = Paths.get(rootFolder);
            Path file = root.resolve(name);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

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

    //Update
    public Document update(Document document, Long id){
        if(id == document.getId()){
            Document documentUpdated = documentRepository.findById(id).get();
            documentUpdated.setName(document.getName());
            documentUpdated.setUrl((document.getUrl()));
            return documentRepository.save(documentUpdated);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    //Delete
    public void delete(Long id){
        documentRepository.deleteById(id);
    }
}
