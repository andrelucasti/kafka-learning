package com.andrelucasdeveloper.kafkalearning.producer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);
    private Producer<String, String> kafkaProducer;

    public ProducerController(final Producer<String, String> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public void sendMessage(@RequestBody final String message) {
        final var key = UUID.randomUUID();
        final var producerRecord = new ProducerRecord<>("NEW_ORDER", key.toString(), message);

        kafkaProducer.send(producerRecord, (recordMetadata, e) -> {
            if(e != null){
                LOGGER.error("Error", e);
            }

            final var messageSuccess = String.format("Success!!! TOPIC: %s, DATA_PARTITION: %s, OFFSET: %s, TIMESTAMP: %s",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), recordMetadata.timestamp());
            LOGGER.info(messageSuccess);
        });
    }
}
