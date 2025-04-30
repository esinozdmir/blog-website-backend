package com.esinozdemir.blog_website_backend.service.impl;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.dto.BlogLikeDto;
import com.esinozdemir.blog_website_backend.entity.BlogLikes;
import com.esinozdemir.blog_website_backend.entity.BlogPost;
import com.esinozdemir.blog_website_backend.mapper.BlogLikeMapper;
import com.esinozdemir.blog_website_backend.mapper.BlogMapper;
import com.esinozdemir.blog_website_backend.repository.BlogLikeRepository;
import com.esinozdemir.blog_website_backend.repository.BlogRepository;
import com.esinozdemir.blog_website_backend.service.BlogLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BlogLikeServiceImpl implements BlogLikeService {

    @Autowired
    BlogLikeRepository blogLikeRepository;
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public ResponseEntity<Boolean> blogLikedUsers(BlogLikeDto blogLikeDto) {
        if (blogLikeRepository.existsByUserIdAndBlogPost((blogLikeDto.getUserId()),blogLikeDto.getBlogPost())) {
            return ResponseEntity.ok(false);
        }
        BlogLikes blogLikes = BlogLikeMapper.mapToBlogLike(blogLikeDto);
        blogLikeRepository.save(blogLikes);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> blogUnlikedUsers(BlogLikeDto blogLikeDto) {
        try {
            BlogLikes blogLikes =  blogLikeRepository.findByBlogPostAndUserId(blogLikeDto.getBlogPost(), blogLikeDto.getUserId()).get(0);
            blogLikeRepository.delete(blogLikes);
            return ResponseEntity.ok(true);
        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }


}
