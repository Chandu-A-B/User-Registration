package com.example.userDataProducer.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.userDataProducer.constant.Constants;
import com.example.userDataProducer.model.User;

@Configuration
public class KafkaProducerConfig {

	@Bean
	public ProducerFactory<String,User> setConfig(){
		
		HashMap<String,Object> con=new HashMap();
		con.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.host);
		con.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		con.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(con);
	}
	
	@Bean
	public KafkaTemplate<String,User> kt(){
		return new KafkaTemplate<String,User>(setConfig());
	}


}
