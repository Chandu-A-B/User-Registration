package com.consumer.registration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.consumer.registration.securityConfig.*;
import com.consumer.registration.model.User;
import com.consumer.registration.repository.Repository;

@Component
public class UserDetailServ implements UserDetailsService {
	
	@Autowired
	private Repository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> per=repo.findById(username);
		
		return per.map(UserDetailConfig::new).orElseThrow(
				()->new UsernameNotFoundException("User with "+username+" is Not Found!"));
	}

}
