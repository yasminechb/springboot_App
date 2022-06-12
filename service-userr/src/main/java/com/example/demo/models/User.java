package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; 
	
  private String firstname;
	
  private String lastname;
  @ManyToOne
  private Location location; 
  
  private String email;
 /* @OneToMany (mappedBy="user")
  private List<Post> posts ;*/
public User(Long id, String firstname, String lastname, Location location, String email) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.location = location;
	this.email = email;
	/*this.posts = posts;*/
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public Location getLocation() {
	return location;
}
public void setLocation(Location location) {
	this.location = location;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
/*public List<Post> getPosts() {
	return posts;
}
public void setPosts(List<Post> posts) {
	this.posts = posts;
}*/
  

}
