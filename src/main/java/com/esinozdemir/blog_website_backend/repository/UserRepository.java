package com.esinozdemir.blog_website_backend.repository;

import com.esinozdemir.blog_website_backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository <Users,Long>{
    Users findByEmail(String email);
}
