package com.esinozdemir.blog_website_backend.service.impl;

import com.esinozdemir.blog_website_backend.dto.UserDto;
import com.esinozdemir.blog_website_backend.entity.Users;
import com.esinozdemir.blog_website_backend.mapper.BlogMapper;
import com.esinozdemir.blog_website_backend.mapper.UserMapper;
import com.esinozdemir.blog_website_backend.repository.UserRepository;
import com.esinozdemir.blog_website_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = UserMapper.mapToUsers(userDto);
        Users savedUsers = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUsers);
    }

    @Override
    public UserDto loginUser(String email, String password) {
        Users loginUser = userRepository.findByEmail(email);
        if (loginUser != null && loginUser.getPassword().equals(password)) {
            UserDto userDto = UserMapper.mapToUserDto(loginUser);
            return userDto;
        }
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        return UserMapper.mapToUserDto(userRepository.findById(id).get());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Users existingUser = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            userDto.setPassword(existingUser.getPassword());
        }

        Users updatedUser = userRepository.save(UserMapper.mapToUsers(userDto));
        return UserMapper.mapToUserDto(updatedUser);
    }


    @Override
    public String updatePassword(Long id,String password) {

        Users user = userRepository.findById(id).get();
        user.setPassword(password);
        userRepository.save(user);

        return "success";
    }

    @Override
    public String checkPassword(Long id, String password) {
        Users user = userRepository.findById(id).get();
        if (!user.getPassword().equals(password)) {
            return "fail";
        }
        else {
            return "success";
        }
    }
}
