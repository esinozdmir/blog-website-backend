package com.esinozdemir.blog_website_backend.mapper;

import com.esinozdemir.blog_website_backend.dto.CommentDto;
import com.esinozdemir.blog_website_backend.entity.Comments;

public class CommentMapper {

    public static Comments mapToComment(CommentDto commentDto) {
        return new Comments(
                commentDto.getCommentId(),
                commentDto.getUserId(),
                commentDto.getComment(),
                commentDto.getCommentDate(),
                commentDto.getBlogPost()
        );
    }

    public static CommentDto mapToCommentDto(Comments comments) {
        return new CommentDto(
                comments.getCommentId(),
                comments.getUserId(),
                comments.getComment(),
                comments.getCommentDate(),
                comments.getBlogPost()
        );
    }


}
