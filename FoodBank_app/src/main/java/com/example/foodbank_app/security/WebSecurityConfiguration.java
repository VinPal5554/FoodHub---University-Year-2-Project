package com.example.foodbank_app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.foodbank_app.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomLoginSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(
				"/registration","/","/businessregistration","/reset_password_Message","/forgot_password","/reset_password","/forgot_password_form","/reset_password_form", "/js/**", "/css/**", "/img/**", "/aboutus", "/adminregistration", "/adminhomepage", 
				"/feedback", "/businesshomepage", "/pointtransaction", "/notFound", "/feedback").permitAll()
		
//        .antMatchers("/").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_FOODBANK")
		
		//.antMatchers("/businesshomepage","/editbusiness","/pointtransaction","pointtransaction/**","/points/**").hasAnyAuthority("ROLE_FOODBANK")
		
        .antMatchers("/new","/edit/**","/delete/**","/deletefeedback/**","/adminhomepage","/admin/**","/editadmin").hasAuthority("ROLE_ADMIN")
        
       // .antMatchers("/redeem/**","/profilePage").hasAuthority("ROLE_USER")
        
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.failureUrl("/login?error=true")
		.successHandler(successHandler)
        .and()
        .logout().permitAll()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout")
        .and()
		.rememberMe()
        .key("privateKey")
        .tokenValiditySeconds(1 * 24 * 60 * 60)
    .userDetailsService(userService)
    ;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
}
