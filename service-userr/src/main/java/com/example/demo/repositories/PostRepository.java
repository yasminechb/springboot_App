package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Post;

public interface PostRepository extends JpaRepository<Post,Long> {

}