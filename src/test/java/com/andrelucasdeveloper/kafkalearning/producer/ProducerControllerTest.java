package com.andrelucasdeveloper.kafkalearning.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProducerControllerTest {

    @Test
    void shouldSendMessage() {

        final var kafkaProducer = mock(KafkaProducer.class);
        var producerController = new ProducerController(kafkaProducer);
            producerController.sendMessage("My First Msg to kafka");

        verify(kafkaProducer).send(any(ProducerRecord.class));
    }
}