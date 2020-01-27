package com.pluralsight.globomantics.springintegration.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.stereotype.Service;

@Service
public class ErrorChannelService {
    private static final Logger logger = LogManager.getLogger(ErrorChannelService.class);

    @ServiceActivator(inputChannel = "errorChannel")
    void handleException(Message<MessageHandlingException> message) {
        MessageHandlingException ex = message.getPayload();

        logger.error("Message handling threw an exception for message: {}. {}",
                ex.getFailedMessage(),
                ex.getMessage());
    }
}
