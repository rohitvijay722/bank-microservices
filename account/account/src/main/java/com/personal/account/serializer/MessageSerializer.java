package com.personal.account.serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.account.dto.Message;

public class MessageSerializer implements Serializer<Message>{

	@Override
	public byte[] serialize(String topic, Message data) {
		// TODO Auto-generated method stub
		byte[] bytes = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            bytes = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
	}

}
