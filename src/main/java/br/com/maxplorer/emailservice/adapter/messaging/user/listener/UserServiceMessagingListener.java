package br.com.maxplorer.emailservice.adapter.messaging.user.listener;

import br.com.maxplorer.emailservice.adapter.messaging.MessagingChannels;
import br.com.maxplorer.emailservice.adapter.messaging.user.event.UserCreatedEvent;
import br.com.maxplorer.emailservice.core.application.EmailApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMessagingListener {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceMessagingListener.class);

    private EmailApplicationService emailApplicationService;

    @Autowired
    public UserServiceMessagingListener(EmailApplicationService emailApplicationService) {
        this.emailApplicationService = emailApplicationService;
    }

    @StreamListener(value = MessagingChannels.USER_SERVICE_INPUT)
    public void userCreatedEvent(@Payload UserCreatedEvent event) {

        LOG.info("Receiving event from user-service: {}", event);

        emailApplicationService.sendEmail(event.toNewUserEmailCommand());
    }
}
