package com.example.foodbank_app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	private String name;
	
	public Role() {
		
		
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}

	public void setID(Long myid) {
		this.id = myid;
	}
	public Long getID(Long myid) {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String myName) {
		this.name = myName;
	}
	
}
