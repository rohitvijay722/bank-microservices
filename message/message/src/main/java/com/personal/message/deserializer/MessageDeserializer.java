package com.personal.message.deserializer;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.message.dto.Message;

public class MessageDeserializer implements Deserializer<Message>{ 

	@Override
	public Message deserialize(String topic, byte[] data) {
		ObjectMapper mapper=new ObjectMapper();
		
		Message msg=null;
		try {
			msg = mapper.readValue(data, Message.class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

}
