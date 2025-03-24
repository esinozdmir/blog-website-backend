package com.esinozdemir.blog_website_backend.service;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.dto.CommentDto;
import com.esinozdemir.blog_website_backend.entity.BlogPost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    public CommentDto createComment(CommentDto commentDto);
    public List<CommentDto> listComment(BlogDto blogPostId);
    public String deleteComment(Long id);
    public CommentDto updateComment(CommentDto commentDto);
}
