package com.andrelucasdeveloper.kafkalearning;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Properties;

@Configuration
public class KafkaConsumerConfiguration {

    @Bean("kafkaConsumer")
    public Consumer<String, String> kafkaConsumer(){
        final var consumer = new KafkaConsumer<String, String>(properties());
        consumer.subscribe(Collections.singleton("NEW_ORDER"));
        return consumer;
    }

    //Could get properties by application.yml, but let's take easy my friend. Baby steps
    private Properties properties() {
        final var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "group-email");//the group name is based in the service name or project name...
        return properties;
    }
}
