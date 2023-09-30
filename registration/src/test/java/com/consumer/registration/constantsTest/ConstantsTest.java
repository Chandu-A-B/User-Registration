package com.consumer.registration.constantsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.consumer.registration.constants.Constants;

@SpringBootTest
public class ConstantsTest {

	@InjectMocks
	private Constants constants;
	
	@Test
	public void testConstants() {
		assertEquals(constants.host,"localhost:9092");
		assertEquals(constants.topic,"userData");
		
	}

}
