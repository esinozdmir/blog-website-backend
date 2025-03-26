package com.esinozdemir.blog_website_backend.dto;

import com.esinozdemir.blog_website_backend.entity.BlogLikes;
import com.esinozdemir.blog_website_backend.entity.Comments;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {

    private Long blogPostId;

    private String authorId;

    private String title;

    private String content;

    private List<Comments> comments;

    private String imageUrl;

    private Date blogDate;

    private Long blogLike;

    private List<BlogLikes> likes;

}
