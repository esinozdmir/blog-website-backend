package com.esinozdemir.blog_website_backend.controller;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.dto.CommentDto;
import com.esinozdemir.blog_website_backend.entity.BlogPost;
import com.esinozdemir.blog_website_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/comment/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "create-comment")
    public CommentDto createComment(@RequestBody CommentDto commentDto) {

        return commentService.createComment(commentDto);

    }

    @PostMapping("list-comment")
    public List<CommentDto> listComment(@RequestBody BlogDto blogDto) {
        return commentService.listComment(blogDto);
    }

    @DeleteMapping("delete-comment")
    public String deleteComment(@RequestParam (name = "id")Long id) {
        return commentService.deleteComment(id);
    }

    @PutMapping("update-comment")
    public CommentDto updateComment(@RequestBody CommentDto commentDto) {
        return  commentService.updateComment(commentDto);
    }

}
