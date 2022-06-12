package com.example.demo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="LOCATIONS")
public class Location {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id; 
	@Column(name="nom")
      private String name; 
     /* @OneToMany(mappedBy="location")
      @Column(name="utilisateurs")
     private List<User> users;*/
	public Location()
	{
		
	}
	public Location(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		/*this.users = users;*/
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}*/
      
}
