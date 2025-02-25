package com.personal.account.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.personal.account.commons.CommonConstants;
import com.personal.account.dto.Message;

public class KafkaConfig {
	
	    @Value("${spring.kafka.bootstrap-servers}")
	    String bootstrapServers;
	    
	    @Value("${spring.kafka.producer.value-serializer}")
	    String valueSerializer;
	    
	    @Value("${spring.kafka.topic-name}")
	    private String topicName;
	    
	    @Bean
	    public ProducerFactory<String, Message> producerFactory() {
	        Map<String, Object> config = new HashMap<>();
	        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	        config.put(CommonConstants.VALUE_SERIALIZER, valueSerializer);
	        return new DefaultKafkaProducerFactory<>(config);
	    }
	    
	    @Bean
	    public NewTopic taskTopic() {
	        return TopicBuilder.name(topicName)
	                .partitions(1)
	                .replicas(1)
	                .build();
	    }
	    @Bean
	    public KafkaTemplate<String, Message> kafkaTemplate() {
	        return new KafkaTemplate<>(producerFactory());
	    }
    
}
