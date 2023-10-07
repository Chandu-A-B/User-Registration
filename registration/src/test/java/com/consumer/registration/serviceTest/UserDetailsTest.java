package com.consumer.registration.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.consumer.registration.model.User;
import com.consumer.registration.repository.Repository;
import com.consumer.registration.service.UserDetailServ;

@SpringBootTest
class UserDetailsTest {

	@InjectMocks
	private UserDetailServ personInfoUserDetails;
	
	@Mock
	private Repository repo;
	
	@Test
	public void testLoadUserByUsername() {
		User dd1=new User("dd","dd1","dd1","dd1","dd1","dd1");
		when(repo.findById("dd")).thenReturn(Optional.of(dd1));
		org.springframework.security.core.userdetails.UserDetails ss=personInfoUserDetails.loadUserByUsername("dd");
		assertNotNull(ss);

	}

}
