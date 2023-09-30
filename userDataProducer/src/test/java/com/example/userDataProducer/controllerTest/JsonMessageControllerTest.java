package com.example.userDataProducer.controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.userDataProducer.controller.JsonMessageController;
import com.example.userDataProducer.model.User;

@SpringBootTest
class JsonMessageControllerTest {

	@InjectMocks
	private JsonMessageController controller;
	
	@Mock
	private KafkaTemplate<String,User> temp;
	
	@Test
	public void testsendmessage() {
		User user=new User();
		ResponseEntity<String> dummy=controller.sendmessage(user);
		assertEquals(dummy.getStatusCode(), HttpStatus.CREATED);
	}

}
