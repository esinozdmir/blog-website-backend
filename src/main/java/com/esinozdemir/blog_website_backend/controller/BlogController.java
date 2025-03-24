package com.esinozdemir.blog_website_backend.controller;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.entity.Comments;
import com.esinozdemir.blog_website_backend.service.BlogService;
import com.esinozdemir.blog_website_backend.service.FileUploadService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/blog/")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping(value = "create-blog-post", consumes = {"multipart/form-data"})
    public BlogDto createBlogPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "comment", required = false) String commentJson,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "blogDate", required = false) String date,
            @RequestParam(value = "blogLike", required = false) Long like
    ) {
        return blogService.createBlogPost(title, content, userId, commentJson, file, date, like);
    }

    @GetMapping(path = "list-blog-post")
    public List<BlogDto> listBlogPost() {
        return blogService.getBlogPosts();
    }

    @GetMapping(path = "get-post-by-id")
    public List<BlogDto>  getBlogPostById(@RequestParam(name = "id") String id) {
        return blogService.getPostById(id);
    }

    @DeleteMapping("delete-blog-post")
    public String deleteBlogPost(@RequestParam (name = "id")Long id) {
        return blogService.deleteBlogPost(id);
    }

    @PutMapping("update-blog-post")
    public BlogDto updateBlogPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "comment", required = false) String commentJson,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "id", required = false) Long blogPostId,
            @RequestParam(value = "blogDate", required = false) String date,
            @RequestParam(value = "blogLike", required = false) Long like
    ) {
        return blogService.updateBlogPost(title, content, userId, commentJson, file, blogPostId, date, like);
    }

    

}
