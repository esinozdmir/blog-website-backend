package com.esinozdemir.blog_website_backend.dto;

import com.esinozdemir.blog_website_backend.entity.BlogPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long commentId;

    private Long userId;

    private String comment;

    private Date commentDate;

    private BlogPost blogPost;
}
