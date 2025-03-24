package com.esinozdemir.blog_website_backend.controller;

import com.esinozdemir.blog_website_backend.dto.UserDto;
import com.esinozdemir.blog_website_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "register")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping(path = "login")
    public UserDto loginUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        return userService.loginUser(email,password);
    }

    @GetMapping(path = "get-user-by-id")
    public UserDto getUserById(@RequestParam(name = "id") Long id) {
        return userService.getUserById(id);
    }

    @PatchMapping(path = "update-user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @PutMapping(path = "update-password")
    public String updatePassword(@RequestParam(name = "id") Long id, @RequestParam(name = "password") String password) {
        return userService.updatePassword(id, password);
    }

    @GetMapping(path = "check-password")
    public String checkPassword(@RequestParam(name = "id") Long id, @RequestParam(name = "password") String password) {
        return userService.checkPassword(id, password);
    }

}
