package com.esinozdemir.blog_website_backend.service.impl;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.dto.BlogLikeDto;
import com.esinozdemir.blog_website_backend.entity.BlogLikes;
import com.esinozdemir.blog_website_backend.mapper.BlogLikeMapper;
import com.esinozdemir.blog_website_backend.mapper.BlogMapper;
import com.esinozdemir.blog_website_backend.repository.BlogLikeRepository;
import com.esinozdemir.blog_website_backend.service.BlogLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BlogLikeServiceImpl implements BlogLikeService {

    @Autowired
    BlogLikeRepository blogLikeRepository;

    @Override
    public ResponseEntity<Boolean> blogLikedUsers(BlogLikeDto blogLikeDto) {
        if (blogLikeRepository.existsByUserIdAndBlogPost((blogLikeDto.getUserId()),blogLikeDto.getBlogPost())) {
            return ResponseEntity.ok(false);
        }
        BlogLikes blogLikes = BlogLikeMapper.mapToBlogLike(blogLikeDto);
    blogLikeRepository.save(blogLikes);
        return ResponseEntity.ok(true);
    }
}
