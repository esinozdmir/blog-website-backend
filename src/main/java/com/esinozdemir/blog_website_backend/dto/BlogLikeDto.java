package com.esinozdemir.blog_website_backend.dto;

import com.esinozdemir.blog_website_backend.entity.BlogPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogLikeDto {

    private Long id;

    private BlogPost blogPost;

    private Long userId;
}
