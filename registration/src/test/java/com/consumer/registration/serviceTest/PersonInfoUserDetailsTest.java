package com.consumer.registration.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.consumer.registration.model.User;
import com.consumer.registration.repository.Repository;
import com.consumer.registration.service.PersonInfoUserDetails;

@SpringBootTest
class PersonInfoUserDetailsTest {

	@InjectMocks
	private PersonInfoUserDetails personInfoUserDetails;
	
	@Mock
	private Repository repo;
	
	@Test
	public void testLoadUserByUsername() {
		User dd1=new User("dd","dd1","dd1","dd1","dd1","dd1");
		when(repo.findById("dd")).thenReturn(Optional.of(dd1));
		UserDetails ss=personInfoUserDetails.loadUserByUsername("dd");
		assertNotNull(ss);

	}

}
