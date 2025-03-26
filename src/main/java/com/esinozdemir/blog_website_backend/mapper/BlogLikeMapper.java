package com.esinozdemir.blog_website_backend.mapper;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.dto.BlogLikeDto;
import com.esinozdemir.blog_website_backend.entity.BlogLikes;
import com.esinozdemir.blog_website_backend.entity.BlogPost;

public class BlogLikeMapper {
    public static BlogLikeDto maptoBlogLikeDto(BlogLikes blogLikes) {
        return new BlogLikeDto(
                blogLikes.getId(),
                blogLikes.getBlogPost(),
                blogLikes.getUserId()


        );

    }

    public static BlogLikes mapToBlogLike(BlogLikeDto blogLikeDto){
        return new BlogLikes(
                blogLikeDto.getId(),
                blogLikeDto.getBlogPost(),
                blogLikeDto.getUserId()
        );

    }
}
