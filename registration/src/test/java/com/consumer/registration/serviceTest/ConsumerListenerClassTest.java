package com.consumer.registration.serviceTest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.consumer.registration.repository.Repository;
import com.consumer.registration.service.ConsumerListenerClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest
class ConsumerListenerClassTest {

	@InjectMocks
	private ConsumerListenerClass listen;
	
	@Mock
	private Repository repo;
	
	@Mock
	private PasswordEncoder encoder;
	
	@Test
	public void testListener() throws JsonMappingException, JsonProcessingException {
		listen.Listener("{\r\n"
				+ "   \r\n"
				+ "	\"userName\":\"Chandu\",\r\n"
				+ "	\"firstName\":\"Chandu Reddy\",\r\n"
				+ "	\"lastName\":\"A B\",\r\n"
				+ "	\"role\":\"admin\",    \r\n"
				+ "    \"email\":\"chandu@gmail.com\",\r\n"
				+ "	\"password\":\"123456\"\r\n"
				+ "}");
	}


}
