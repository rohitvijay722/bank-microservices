package com.personal.message.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.personal.message.commons.CommonConstants;
import com.personal.message.dto.Message;

@Service
public class KafkaConsumerService {
	
	
	@KafkaListener(topics = "message", groupId = "message")
	public void consume(Message myMsg) {
		//this is for testing purpose, for real world a sms or email is supposed to send to the user
		System.out.println(CommonConstants.CONSUMER_MESSAGE+myMsg.getHeader()+" "+myMsg.getDesc());
	}
}