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
public class ListenerClass {
	@Autowired
	private Repository repo;
	
	@Autowired
	private PasswordEncoder encoder;

	@KafkaListener(groupId = "userGroup",topics = "userData")
	public void Listener(String mes) throws JsonMappingException, JsonProcessingException {
		System.out.println(mes);
		System.out.println("in listener");
		ObjectMapper obj=new ObjectMapper();
		User perr=obj.readValue(mes,User.class);
		perr.setPassword(encoder.encode(perr.getPassword()));
		System.out.println(perr.getPassword());
		repo.save(perr);
		System.out.println("Consumer data received");
	}
}
