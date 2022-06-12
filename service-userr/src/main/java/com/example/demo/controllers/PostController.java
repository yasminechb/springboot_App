package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Location;
import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.repositories.LocationRepository;
import com.example.demo.repositories.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	
	
	
	//get post
	
	@GetMapping("/posts")
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}
	
	
	//get post by id 
	
	@GetMapping("/Posts/{id}")
	public Post  getLocationById(@PathVariable(value = "id" )Long postId){
		Post post = postRepository.findById(postId).get();
		return post;
	}
	//save post
	@PostMapping("posts")
	public Post createPost(@RequestBody Post post )
	{
		return this.postRepository.save(post);
	}

}
