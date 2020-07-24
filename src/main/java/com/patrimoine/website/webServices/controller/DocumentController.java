package com.patrimoine.website.webServices.controller;

import com.patrimoine.website.upload.ResponseMessage;
import com.patrimoine.website.webServices.entity.Document;
import com.patrimoine.website.webServices.entity.User;
import com.patrimoine.website.webServices.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping(value = "/documents")
@RestController
@PreAuthorize("hasAuthority('admin')")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Document> getAll() {
        return documentService.getAll();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin') or hasAuthority('user') ")
    public Document getById(@PathVariable Long id) {

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Document document = documentService.getById(id);

        if (!currentUser.getRole().equals("admin") && !(document.getProject()).getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("Vous n'êtes pas autorisé a accéder cette ressource");
        }


        return document;
    }


    @GetMapping("/file/{documentname:.+}")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin') or hasAuthority('user') ")
    public ResponseEntity<Resource> getDocument(@PathVariable String documentname) {

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Resource document = documentService.load(documentname);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; documentname=\"" + document.getFilename() + "\"").body(document);
    }

    @PostMapping("/upload/{id}")
    @PreAuthorize("hasAuthority('admin')")
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
    @PreAuthorize("hasAuthority('admin')")
    public Document put(@RequestBody Document document, @PathVariable Long id) {
        return documentService.update(document, id);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public void delete(@PathVariable Long id) {
        documentService.delete(id);
    }
}


