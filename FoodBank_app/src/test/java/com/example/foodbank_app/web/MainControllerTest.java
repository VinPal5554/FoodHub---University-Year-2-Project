package com.example.foodbank_app.web;


import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import com.example.foodbank_app.model.User;
import com.example.foodbank_app.repository.FoodbankRepository;
import com.example.foodbank_app.repository.PagingRepository;
import com.example.foodbank_app.repository.RoleRepository;
import com.example.foodbank_app.repository.UserRepository;
import com.example.foodbank_app.service.UserService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class MainControllerTest {
	
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private RoleRepository rolerepository;
	@Autowired
	private FoodbankRepository foodbankrepository;
	@Autowired
	private PagingRepository pagingrepository;
	
	
	
	@Test
	public void testForSorting() {
		
		String sortDir ="asc";
		String sortField = "id";
		
		int pageNum = 1;
	    int pageSize = 5;
	     Sort sort = Sort.by(sortField);
	     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		
		Page<User> users = pagingrepository.findAll("", pageable);
		for(User user:users) {
			System.out.println(user);
		}
		
		assertThat(users).size().isGreaterThan(0);
	}
	
//	@Test
//	public void testForListLeaderboard() {
//		
//		String sortDir ="desc";
//		String sortField = "points";
//		
//		int pageNum = 1;
//	    int pageSize = 5;
//	     Sort sort = Sort.by(sortField);
//	     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
//	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
//		
//		
//		Page<User> users = foodbankrepository.findAll("", pageable);
//		for(User user:users) {
//			System.out.println(user);
//		}
//		
//		assertThat(users).size().isGreaterThan(0);
//	}
	
	
}
	






























