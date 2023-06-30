package com.example.foodbank_app.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.foodbank_app.model.User;
	
		public interface PagingRepository extends PagingAndSortingRepository <User, Long>{
			
		    @Query("SELECT p FROM User p WHERE "
		            + "CONCAT(p.username, ' ', p.firstName, ' ', p.lastName, ' ', p.email) "
		            + "LIKE %?1%")
		    public Page<User> findAll(String keyword, Pageable pageable);
		}
