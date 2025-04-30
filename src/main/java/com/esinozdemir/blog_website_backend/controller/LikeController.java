package com.esinozdemir.blog_website_backend.controller;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.dto.BlogLikeDto;
import com.esinozdemir.blog_website_backend.entity.BlogLikes;
import com.esinozdemir.blog_website_backend.service.BlogLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("api/blogLikes/")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LikeController {

    @Autowired
    BlogLikeService blogLikeService;

    @PostMapping(path = "like-post")
    ResponseEntity<Boolean> blogLikedUsers(@RequestBody BlogLikeDto blogLikeDto) {
        return blogLikeService.blogLikedUsers(blogLikeDto);
    }

    @DeleteMapping(path = "unLike-post")
    ResponseEntity<Boolean> blogUnlikedUsers(@RequestBody BlogLikeDto blogLikeDto) {
        return blogLikeService.blogUnlikedUsers(blogLikeDto);
    }

}
