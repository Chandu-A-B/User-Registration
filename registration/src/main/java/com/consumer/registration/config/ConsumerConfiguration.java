package com.consumer.registration.config;

import java.util.HashMap;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import com.consumer.registration.constants.Constants;
import com.consumer.registration.model.User;

@Configuration
public class ConsumerConfiguration {

	@Bean
	public ConsumerFactory<String,User> consumerFactory() {
		HashMap<String,Object> dsad=new HashMap();
		dsad.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,Constants.host);
		dsad.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		dsad.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(dsad);
		
		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory concurrentKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory eew=new ConcurrentKafkaListenerContainerFactory();
		eew.setConsumerFactory(consumerFactory());
		return eew;
	}
}
