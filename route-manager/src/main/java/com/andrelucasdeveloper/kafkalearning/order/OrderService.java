package com.andrelucasdeveloper.kafkalearning.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    protected static final Logger LOGGER = LoggerFactory.getLogger(OrderCreationConsumer.class);

    public void saveOrdersAvailableToNewTrip() {
        LOGGER.info("Saving new orders available.");
    }
}
