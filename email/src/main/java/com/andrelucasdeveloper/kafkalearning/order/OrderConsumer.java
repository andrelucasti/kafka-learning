package com.andrelucasdeveloper.kafkalearning.order;

import com.andrelucasdeveloper.kafkalearning.notification.EmailService;
import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class OrderConsumer {
    protected static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
    private Consumer<String, String> kafkaConsumer;
    private EmailService emailService;

    public OrderConsumer(final Consumer<String, String> kafkaConsumer,
                         final EmailService emailService) {
        this.kafkaConsumer = kafkaConsumer;
        this.emailService = emailService;
    }


    public void execute(){
        while (true)
            consumer();
    }

    private void consumer(){
        final var records = kafkaConsumer.poll(Duration.ofMillis(200));
        if(!records.isEmpty()){
            for(var record: records){
                final var messageSuccess = String.format("Received msg!!! TOPIC: %s, DATA_PARTITION: %s, OFFSET: %s, TIMESTAMP: %s",
                        record.topic(), record.partition(), record.offset(), record.timestamp());
                LOGGER.info("-----------------------------");
                LOGGER.info("Processing msg");
                LOGGER.info(messageSuccess);
                LOGGER.info(record.key());
                LOGGER.info(record.value());

                emailService.send();
            }
        }
    }
}
