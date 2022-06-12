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

@RestController
public class PostController {
	
	@Autowired
	private LocationRepository postRepository;
	
	
	
	
	//get post
	
	@GetMapping("/posts")
	public List<Location> getAllPost() {
		return postRepository.findAll();
	}
	
	
	//get post by id 
	
	@GetMapping("/Posts/{id}")
	public Location  getLocationById(@PathVariable(value = "id" )Long postId){
		Location location = postRepository.findById(postId).get();
		return location;
	}

}
