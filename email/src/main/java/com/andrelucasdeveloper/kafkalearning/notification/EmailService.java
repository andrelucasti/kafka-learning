package com.andrelucasdeveloper.kafkalearning.notification;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements SendNotification{
    protected static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    @Override
    public void send() {
        LOGGER.info("Sending email");
    }
}
