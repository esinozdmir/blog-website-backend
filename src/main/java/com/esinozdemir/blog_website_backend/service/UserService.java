package com.esinozdemir.blog_website_backend.service;

import com.esinozdemir.blog_website_backend.dto.UserDto;
import com.esinozdemir.blog_website_backend.entity.Users;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto loginUser(String email, String password);

    UserDto getUserById(Long id);

    UserDto updateUser(UserDto userDto);

    String updatePassword(Long id, String password);
    String checkPassword(Long id, String password);
}
