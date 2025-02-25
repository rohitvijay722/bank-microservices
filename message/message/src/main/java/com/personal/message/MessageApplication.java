package com.personal.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.personal.message.service.KafkaConsumerService;

@SpringBootApplication
public class MessageApplication {	

	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}

}
