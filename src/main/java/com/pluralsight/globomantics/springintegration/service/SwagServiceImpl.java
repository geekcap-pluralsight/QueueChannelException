package com.pluralsight.globomantics.springintegration.service;

import com.pluralsight.globomantics.springintegration.model.Swag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class SwagServiceImpl implements SwagService {
    private static final Logger logger = LogManager.getLogger(SwagServiceImpl.class);

    @ServiceActivator(inputChannel = "queueChannel", poller = @Poller(fixedDelay = "100"))
    @Override
    public void sendSwag(Message<Swag> swag) {
        logger.info("Received message to send swag: {}", swag.getPayload());

        if (swag.getPayload().getType().equalsIgnoreCase("Hat")) {
            throw new RuntimeException("We're out of hats, sorry");
        }

        try {
            // Sleep for 1 second to demonstrate queueing behavior
            Thread.sleep(1000);
        } catch (Exception ignored) {}
    }
}
