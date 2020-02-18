package br.com.maxplorer.emailservice.adapter.messaging.user.event;

import br.com.maxplorer.emailservice.core.application.command.UserCreatedEmailCommand;

import java.util.UUID;

class UserCreatedEventTestFixture {

    private UserCreatedEventTestFixture() {
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
