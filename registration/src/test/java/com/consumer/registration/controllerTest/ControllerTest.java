package com.consumer.registration.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.consumer.registration.controller.Controller;
import com.consumer.registration.model.User;
import com.consumer.registration.repository.Repository;

@SpringBootTest
class ControllerTest {

	@InjectMocks
	private Controller controller;
	
	@Mock
	private Repository repo;
	
	@Mock
	private PasswordEncoder encode;
	
	@Test
	public void testDelete() {
		ResponseEntity<String> del=controller.DeleteById("dd");
		assertEquals(del.getBody(),"");
	}

	@Test
	public void testUpdateFindById() {
		User dd=new User();
		dd.setEmail("dd");
		dd.setFirstName("dd");
		dd.setLastName("dd");
		dd.setRole("dd");
		dd.setPassword("dd");
		dd.setUserName("dd");
		User dd1=new User("dd","dd1","dd1","dd1","dd1","dd1");
		when(repo.findById("dd")).thenReturn(Optional.of(dd1));
		ResponseEntity<User> update=controller.UpdateFindById(dd1, "dd");
		assertEquals(update.getStatusCode(),HttpStatus.ACCEPTED);
	}
	
	
	@Test
	public void kuddos() {
		List<User> ns=new ArrayList();
		ns.add(new User("dd","dd1","dd1","dd1","dd1","dd1"));
		ns.add(new User("dd1","dd2","dd2","dd2","dd2","dd2"));
		when(repo.findAll()).thenReturn(ns);
		ResponseEntity<List<User>> allUsers=controller.FindAll();
		assertEquals(allUsers.getBody().size(),2);
	}
}
