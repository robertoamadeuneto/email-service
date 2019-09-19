package br.com.maxplorer.emailservice.adapter.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MessagingChannels {

    String USER_SERVICE_INPUT = "user-service-input";

    @Input(USER_SERVICE_INPUT)
    MessageChannel userServiceInput();
}
