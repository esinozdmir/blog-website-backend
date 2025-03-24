package com.esinozdemir.blog_website_backend.repository;

import com.esinozdemir.blog_website_backend.entity.BlogPost;
import com.esinozdemir.blog_website_backend.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    List<Comments> getCommentsByBlogPost(BlogPost blogPost);
}
