package com.pluralsight.globomantics.springintegration.service;

import com.pluralsight.globomantics.springintegration.config.QueueChannelGateway;
import com.pluralsight.globomantics.springintegration.model.Swag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private QueueChannelGateway swagGateway;

    @Override
    public void commit(String userId) {
        // Send several swag pacakges
        swagGateway.sendSwag(MessageBuilder.withPayload(new Swag("T-Shirt")).build());
        swagGateway.sendSwag(MessageBuilder.withPayload(new Swag("Hat")).build());
        swagGateway.sendSwag(MessageBuilder.withPayload(new Swag("Key chain")).build());
        swagGateway.sendSwag(MessageBuilder.withPayload(new Swag("USB Drive")).build());
        logger.info("Published four Swag items to the Swag queueChannel");

    }
}
