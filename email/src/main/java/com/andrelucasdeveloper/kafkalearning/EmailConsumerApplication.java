package com.andrelucasdeveloper.kafkalearning;

import com.andrelucasdeveloper.kafkalearning.order.OrderConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailConsumerApplication implements CommandLineRunner {

	@Autowired
	private OrderConsumer orderConsumer;

	public static void main(String[] args) {
		SpringApplication.run(EmailConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		orderConsumer.execute();
	}
}
