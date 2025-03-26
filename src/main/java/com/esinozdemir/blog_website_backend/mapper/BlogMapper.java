package com.esinozdemir.blog_website_backend.mapper;

import com.esinozdemir.blog_website_backend.dto.BlogDto;
import com.esinozdemir.blog_website_backend.entity.BlogPost;

public class BlogMapper {
    public static BlogDto maptoBlogDto(BlogPost blogPost) {
        return new BlogDto(
                blogPost.getBlogPostId(),
                blogPost.getAuthorId(),
                blogPost.getTitle(),
                blogPost.getContent(),
                blogPost.getComments(),
                blogPost.getImage(),
                blogPost.getBlogDate(),
                blogPost.getBlogLike(),
                blogPost.getLikes()
        );

    }

    public static BlogPost mapToBlogPost(BlogDto blogDto){
        return new BlogPost(
                blogDto.getBlogPostId(),
                blogDto.getAuthorId(),
                blogDto.getTitle(),
                blogDto.getContent(),
                blogDto.getComments(),
                blogDto.getImageUrl(),
                blogDto.getBlogDate(),
                blogDto.getBlogLike(),
                blogDto.getLikes()

        );

    }
}
