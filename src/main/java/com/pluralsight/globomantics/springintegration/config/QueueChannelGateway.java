package com.pluralsight.globomantics.springintegration.config;

import com.pluralsight.globomantics.springintegration.model.Swag;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "queueChannelGateway", defaultRequestChannel = "queueChannel")
public interface QueueChannelGateway {
    @Gateway
    void sendSwag(Message<Swag> swag);
}