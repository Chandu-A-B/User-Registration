package com.consumer.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.consumer.registration.model.User;
import com.consumer.registration.repository.Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConsumerListenerClass {
	@Autowired
	private Repository repo;
	
	@Autowired
	private PasswordEncoder encoder;

	@KafkaListener(groupId = "testGroup",topics = "useDatas")
	public void Listener(String message) throws JsonMappingException, JsonProcessingException {
		System.out.println(message);
		System.out.println("in listener");
		ObjectMapper obj=new ObjectMapper();
		User use=obj.readValue(message,User.class);
		use.setPassword(encoder.encode(use.getPassword()));
		System.out.println(use.getPassword());
		repo.save(use);
		System.out.println("Consumer data received");
	}
}
