package com.esinozdemir.blog_website_backend.service.impl;


import com.esinozdemir.blog_website_backend.controller.BlogController;
import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.entity.BlogPost;
import com.esinozdemir.blog_website_backend.entity.Comments;
import com.esinozdemir.blog_website_backend.mapper.BlogMapper;
import com.esinozdemir.blog_website_backend.repository.BlogRepository;
import com.esinozdemir.blog_website_backend.service.BlogService;
import com.esinozdemir.blog_website_backend.service.FileUploadService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private FileUploadService fileUploadService;


    @Override
    public BlogDto createBlogPost(String title, String content, Long userId, String commentJson, MultipartFile file, String date, Long like) {
        BlogDto blogDto = new BlogDto();
        blogDto.setTitle(title);
        blogDto.setContent(content);
        if (userId != null)
            blogDto.setAuthorId(userId.toString());

        if (date != null && !date.isEmpty()) {
            Instant instant = Instant.parse(date);
            blogDto.setBlogDate(Date.from(instant));
        }

        blogDto.setBlogLike(like);

        if (commentJson != null) {
            List<Comments> comments = new Gson().fromJson(commentJson, new TypeToken<List<Comments>>() {}.getType());
            blogDto.setComments(comments);
        }

        if (file != null && !file.isEmpty()) {
            String fileName = fileUploadService.uploadFile(file);
            blogDto.setImageUrl(fileName);
        }

        BlogPost saved = blogRepository.save(BlogMapper.mapToBlogPost(blogDto));
        return BlogMapper.maptoBlogDto(saved);
    }

    @Override
    public List<BlogDto> getBlogPosts() {
        List<BlogPost> blogPosts=blogRepository.findAll();
        List<BlogDto> blogDtos =new ArrayList<>();
        for(BlogPost blogPost:blogPosts){
            blogDtos.add(BlogMapper.maptoBlogDto(blogPost));
        }
        return blogDtos;
    }



    @Override
    public List<BlogDto> getPostById(String id) {
        List<BlogPost> blogPosts= blogRepository.getAllByAuthorId(id);
        List<BlogDto> blogDtos =new ArrayList<>();
        for(BlogPost blogPost:blogPosts){
            blogDtos.add(BlogMapper.maptoBlogDto(blogPost));
        }

        return blogDtos;
    }

    @Override
    public String deleteBlogPost(Long id) {
        blogRepository.deleteById(id);
        return "post silindi";
    }

    @Override
    public BlogDto updateBlogPost(String title, String content, Long userId, String commentJson, MultipartFile file, Long blogPostId, String date, Long like) {
        BlogDto blogDto = new BlogDto();
        blogDto.setTitle(title);
        blogDto.setContent(content);
        if (userId != null)
            blogDto.setAuthorId(userId.toString());
        blogDto.setBlogPostId(blogPostId);

        if (date != null && !date.isEmpty()) {
            Instant instant = Instant.parse(date);
            blogDto.setBlogDate(Date.from(instant));
        }

        blogDto.setBlogLike(like);

        if (commentJson != null) {
            List<Comments> comments = new Gson().fromJson(commentJson, new TypeToken<List<Comments>>() {}.getType());
            blogDto.setComments(comments);
        }

        if (file != null && !file.isEmpty()) {
            String fileName = fileUploadService.uploadFile(file);
            blogDto.setImageUrl(fileName);
        }

        BlogPost updated = blogRepository.save(BlogMapper.mapToBlogPost(blogDto));
        return BlogMapper.maptoBlogDto(updated);
    }

    @Override
    public Long addBlogLike(Long id) {
        BlogPost blogPost = blogRepository.findById(id).get();
        if(blogPost.getBlogLike()==null){blogPost.setBlogLike(0L);}
        Long addedblogLike= blogPost.getBlogLike() +1;
        blogPost.setBlogLike(addedblogLike);
         blogRepository.save(blogPost);
        return addedblogLike;
    }




}
