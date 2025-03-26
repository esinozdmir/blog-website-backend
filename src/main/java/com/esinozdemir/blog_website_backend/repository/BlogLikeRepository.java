package com.esinozdemir.blog_website_backend.repository;

import com.esinozdemir.blog_website_backend.entity.BlogLikes;
import com.esinozdemir.blog_website_backend.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogLikeRepository extends JpaRepository<BlogLikes,Long> {


    boolean existsByUserIdAndBlogPost(Long userId, BlogPost blogPost);
}
