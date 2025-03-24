package com.esinozdemir.blog_website_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileUploadService {
    public String uploadFile(MultipartFile file);
}
