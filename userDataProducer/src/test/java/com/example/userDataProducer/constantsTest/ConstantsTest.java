package com.example.userDataProducer.constantsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.userDataProducer.constant.Constants;

@SpringBootTest
class ConstantsTest {

	@InjectMocks
	private Constants constant;
	
	@Test
	public void testConstants() {
		assertEquals(constant.host,"localhost:9092");
		assertEquals(constant.topic,"userData");
	}
	
}
