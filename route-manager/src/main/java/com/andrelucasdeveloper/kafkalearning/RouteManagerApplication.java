package com.andrelucasdeveloper.kafkalearning;

import com.andrelucasdeveloper.kafkalearning.order.OrderCreationConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RouteManagerApplication implements CommandLineRunner {

	@Autowired
	private OrderCreationConsumer orderCreationConsumer;

	public static void main(String[] args) {
		SpringApplication.run(RouteManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		orderCreationConsumer.execute();
	}
}
