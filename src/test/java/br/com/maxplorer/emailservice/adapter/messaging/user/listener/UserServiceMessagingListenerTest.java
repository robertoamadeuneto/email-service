package br.com.maxplorer.emailservice.adapter.messaging.user.listener;

import br.com.maxplorer.emailservice.adapter.messaging.MessagingChannels;
import br.com.maxplorer.emailservice.adapter.messaging.user.event.UserCreatedEvent;
import br.com.maxplorer.emailservice.core.application.EmailApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceMessagingListenerTest {

    @Autowired
    private MessagingChannels channels;

    @MockBean
    private EmailApplicationService emailApplicationService;

    @Test
    public void shouldReceiveUserCreatedEvent() {

        doNothing().when(emailApplicationService).sendUserCreatedEvent(any());

        Message<UserCreatedEvent> message = MessageBuilder.withPayload(UserServiceMessagingListenerTestFixture.userCreatedEvent())
                .setHeader(AmqpHeaders.RECEIVED_ROUTING_KEY, UserServiceMessagingListenerTestFixture.userCreatedEventRoutingKey())
                .build();
        channels.userServiceInput().send(message);

        verify(emailApplicationService).sendUserCreatedEvent(eq(UserServiceMessagingListenerTestFixture.newEmailCommand()));
    }
}
