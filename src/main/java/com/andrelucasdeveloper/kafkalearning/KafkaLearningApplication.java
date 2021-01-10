package com.andrelucasdeveloper.kafkalearning;

import com.andrelucasdeveloper.kafkalearning.consumer.LearningHandler;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaLearningApplication implements CommandLineRunner {

	@Autowired
	private LearningHandler learningHandler;

	public static void main(String[] args) {
		SpringApplication.run(KafkaLearningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		learningHandler.execute();
	}
}
