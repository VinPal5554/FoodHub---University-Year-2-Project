package com.example.foodbank_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foodbank_app.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
}