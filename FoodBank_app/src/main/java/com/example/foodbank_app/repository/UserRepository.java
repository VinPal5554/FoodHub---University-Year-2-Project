package com.example.foodbank_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.foodbank_app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
	User findByPassword(String password);
  
	@Query("SELECT c FROM User c WHERE c.email = ?1")
        User findByEmail(String email);
	
	User findByResetPasswordToken(String token);
	
}
