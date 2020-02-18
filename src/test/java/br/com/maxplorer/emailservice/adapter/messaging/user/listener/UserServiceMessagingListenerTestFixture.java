package br.com.maxplorer.emailservice.adapter.messaging.user.listener;

import br.com.maxplorer.emailservice.adapter.messaging.user.event.UserCreatedEvent;
import br.com.maxplorer.emailservice.core.application.command.UserCreatedEmailCommand;

import java.util.UUID;

class UserServiceMessagingListenerTestFixture {

    private UserServiceMessagingListenerTestFixture() {
    }

    static String userCreatedEventRoutingKey() {
        return "user-service.user.created";
    }

    static UserCreatedEvent userCreatedEvent() {
        return new UserCreatedEvent(UUID.fromString("8089c74f-c660-4c68-9697-4a03144b8e13"),
                "James Gosling",
                "james.gosling@email.com");
    }

    static UserCreatedEmailCommand newEmailCommand() {
        return new UserCreatedEmailCommand("james.gosling@email.com", "James Gosling");
    }
}
