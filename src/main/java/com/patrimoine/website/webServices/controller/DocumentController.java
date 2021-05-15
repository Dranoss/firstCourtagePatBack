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

@RequestMapping(value = "/documents")
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/file/{id}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename, @PathVariable String id) {
        Resource document = documentService.load(filename, id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; getFile=\"" + document.getFilename() + "\"").body(document);
    }


    @PostMapping("/upload/{id}")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("document") MultipartFile document, @PathVariable Long id) {
        String message = "";
        try {
            documentService.save(document, id);

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


