package com.esinozdemir.blog_website_backend.service;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import lombok.Lombok;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface BlogService {
    BlogDto createBlogPost(String title, String content, Long userId, String commentJson, MultipartFile file, String date, Long like);    public List<BlogDto> getBlogPosts();
    public List<BlogDto> getPostById(String id);
    public String deleteBlogPost(Long id);
    BlogDto updateBlogPost(String title, String content, Long userId, String commentJson, MultipartFile file, Long blogPostId, String date, Long like);
    Long addBlogLike(Long id);


}
