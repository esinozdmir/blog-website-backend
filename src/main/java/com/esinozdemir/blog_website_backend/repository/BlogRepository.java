package com.esinozdemir.blog_website_backend.repository;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.entity.BlogPost;
import com.esinozdemir.blog_website_backend.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogPost,Long> {

    List<BlogPost> getAllByAuthorId(String authorId);

    List<BlogPost> findByBlogPostId(Long blogPostId);
}
