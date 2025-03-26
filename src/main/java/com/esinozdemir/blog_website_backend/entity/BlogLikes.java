package com.esinozdemir.blog_website_backend.entity;

import jakarta.persistence.*;

@Entity
public class BlogLikes {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blogPostId", nullable = false)
    private BlogPost blogPost;

    private Long userId;
}
