package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.upload.ResponseMessage;
import com.patrimoine.website.webServices.entity.Document;
import com.patrimoine.website.webServices.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping(value = "/documents")
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /*@GetMapping
    public ResponseEntity<List<Document>> getDocumentList() {
        List<Document> documents = documentService.loadAll().map(path -> {
            String name = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(DocumentController.class, "getFile", path.getFileName().toString()).build().toString();

            return new Document(name, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(documents);
    }*/

    @GetMapping
    public List<Document> getAll(){
       return documentService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Document getById(@PathVariable Long id){
        return documentService.getById(id);
    }

   /* @GetMapping("/{documentname:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getDocument(@PathVariable String documentname) {
        Resource document = documentService.load(documentname);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; documentname=\"" + document.getFilename() + "\"").body(document);
    }*/

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("document") MultipartFile document) {
        String message = "";
        try {
            documentService.save(document);

            message = "Uploaded the file successfully: " + document.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + document.getOriginalFilename() + "!";
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PutMapping(value = "/{id}")
    public Document put(@RequestBody Document document, @PathVariable Long id){
        return documentService.update(document, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        documentService.delete(id);
    }
}


