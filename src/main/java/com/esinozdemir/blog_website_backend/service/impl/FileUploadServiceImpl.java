package com.esinozdemir.blog_website_backend.service.impl;

import com.esinozdemir.blog_website_backend.service.FileUploadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {
    private static final String UPLOAD_DIR = "src/main/resources/static/uploads";

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ("Dosya boş olamaz.");
            }

            String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + fileExtension;

            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return ("http://localhost:8080/uploads/" + fileName);

        } catch (IOException e) {
            e.printStackTrace();
            return ("Dosya yüklenirken bir hata oluştu: " + e.getMessage());
        }
    }
}
