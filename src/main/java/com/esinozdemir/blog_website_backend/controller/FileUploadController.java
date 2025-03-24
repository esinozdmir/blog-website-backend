package com.esinozdemir.blog_website_backend.controller;

import com.esinozdemir.blog_website_backend.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload/")
@CrossOrigin(origins = "http://localhost:4200")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("image")
    String fileUpload(@RequestParam("image") MultipartFile file){
        return fileUploadService.uploadFile(file);
    }
}
