package com.esinozdemir.blog_website_backend.service;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.dto.BlogLikeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface BlogLikeService {
    ResponseEntity<Boolean> blogLikedUsers(BlogLikeDto blogLikeDto);
}
