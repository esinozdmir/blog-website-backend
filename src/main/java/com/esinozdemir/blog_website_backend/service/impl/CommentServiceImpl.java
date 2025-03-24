package com.esinozdemir.blog_website_backend.service.impl;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.dto.CommentDto;
import com.esinozdemir.blog_website_backend.entity.BlogPost;
import com.esinozdemir.blog_website_backend.entity.Comments;
import com.esinozdemir.blog_website_backend.mapper.BlogMapper;
import com.esinozdemir.blog_website_backend.mapper.CommentMapper;
import com.esinozdemir.blog_website_backend.repository.BlogRepository;
import com.esinozdemir.blog_website_backend.repository.CommentRepository;
import com.esinozdemir.blog_website_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    public CommentDto createComment(CommentDto commentDto) {
        Comments comment = CommentMapper.mapToComment(commentDto);
        Comments savedComment = commentRepository.save(comment);
        return CommentMapper.mapToCommentDto(savedComment);
    }

    @Override
    public List<CommentDto> listComment(BlogDto blogDto) {
         BlogPost blogPost = BlogMapper.mapToBlogPost(blogDto);
         List<Comments> comments = commentRepository.getCommentsByBlogPost(blogPost);
         List <CommentDto> commentDtos = new ArrayList<>();
         for (Comments comment : comments) {
             commentDtos.add(CommentMapper.mapToCommentDto(comment));
         }
         return commentDtos;
    }

    @Override
    public String deleteComment(Long id) {
        commentRepository.deleteById(id);
        return "yorum silindi";
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto) {
        Comments comments = CommentMapper.mapToComment(commentDto);
        Comments updatedComment = commentRepository.save(comments);
        return CommentMapper.mapToCommentDto(updatedComment);
    }


}
