package br.com.maxplorer.emailservice.adapter.messaging.user.listener;

import br.com.maxplorer.emailservice.adapter.messaging.MessagingChannels;
import br.com.maxplorer.emailservice.adapter.messaging.user.event.UserCreatedEvent;
import br.com.maxplorer.emailservice.core.application.EmailApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class UserServiceMessagingListener {

    private final EmailApplicationService emailApplicationService;

    @StreamListener(value = MessagingChannels.USER_SERVICE_INPUT, condition = "headers['amqp_receivedRoutingKey'] == 'user-service.user.created'")
    public void userCreatedEvent(@Payload final UserCreatedEvent event) {
        log.info("Receiving an event from user-service: {}", event);

        emailApplicationService.sendUserCreatedEmail(event.toUserCreatedEmailCommand());
    }
}
