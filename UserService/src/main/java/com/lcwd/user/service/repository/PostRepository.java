package com.lcwd.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
