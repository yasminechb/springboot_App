package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ResourceNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;


	
	
	// get user
	
	

	 @GetMapping("/users")
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	
	
	
	//get user by id
	 
	 
	  @GetMapping("/user/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
	        throws ResourceNotFoundException {
	        User user = userRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
	        return ResponseEntity.ok().body(user);
	    }
	
	
	//save user
	  
	  @PostMapping("/user")
	    public User createUser(@RequestBody User user) {
	        return userRepository.save(user);
	    }
	
	//update user
	  
	  
	  @PutMapping("/user/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
	          @RequestBody User userDetails) throws ResourceNotFoundException {
	        User user = userRepository.findById(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        user.setFirstname(userDetails.getFirstname());
	        user.setLastname(userDetails.getLastname());
	        final User updatedUser = userRepository.save(user);
	        return ResponseEntity.ok(updatedUser);
	    }
	
	
	
	//delete user by id 
	  
	  
	  @DeleteMapping("/user/{id}")
	    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
	         throws ResourceNotFoundException {
	        User user = userRepository.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        userRepository.delete(user);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
