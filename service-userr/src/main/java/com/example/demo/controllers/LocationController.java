package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Location;
import com.example.demo.repositories.LocationRepository;

@RestController
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepository;
	
	
	@GetMapping("/hello")
	public String Test() {
		return "heyyyyy";
	}
	
	//get location 
	
	@GetMapping("/locations")
	public List<Location> getAllLocation() {
		return locationRepository.findAll();
	}
	
	
	//get location by id 
	
	@GetMapping("/Locations/{id}")
	public Location  getLocationById(@PathVariable(value = "id" )Long locationId){
		Location location = locationRepository.findById(locationId).get();
		return location;
	}
	
	
	//save location
	@PostMapping("locations")
	public Location createOffer(@RequestBody Location location )
	{
		return this.locationRepository.save(location);
	}
}
