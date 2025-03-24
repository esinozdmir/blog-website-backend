package com.esinozdemir.blog_website_backend.mapper;

import com.esinozdemir.blog_website_backend.dto.UserDto;
import com.esinozdemir.blog_website_backend.entity.Users;
import jakarta.persistence.Column;
import org.apache.catalina.User;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto mapToUserDto(Users users) {
        return new UserDto(
                users.getId(),
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                users.getPassword()
                );

    }
    public static Users mapToUsers(UserDto userDto) {
        return new Users(
                userDto.getId(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getFirstName(),
                userDto.getLastName()
        );
    }
}
