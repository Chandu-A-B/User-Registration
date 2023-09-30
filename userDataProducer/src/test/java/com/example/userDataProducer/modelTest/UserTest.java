package com.example.userDataProducer.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.userDataProducer.model.User;

class UserTest {

	@Test
	void test() {
		User user = new User();
		User users = new User("Chandu","chandu","A B", "chandu@gmail.com","chandu123","user");
		user.setUserName("Chandu");
		assertEquals(user.getUserName(), "Chandu");
		user.setFirstName("chandu");
		assertEquals(user.getFirstName(), "chandu");
		user.setLastName("A B");
		assertEquals(user.getLastName(), "A B" );
		user.setEmail("chandu@gmail.com");
		assertEquals(user.getEmail(), "chandu@gmail.com");
		user.setPassword("chandu123");
		assertEquals(user.getPassword(),"chandu123");
		user.setRole("user");
		assertEquals(user.getRole(), "user");
		
	}

}
