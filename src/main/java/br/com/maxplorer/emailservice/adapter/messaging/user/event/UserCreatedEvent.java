package br.com.maxplorer.emailservice.adapter.messaging.user.event;

import br.com.maxplorer.emailservice.core.application.command.NewEmailCommand;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class UserCreatedEvent {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("email")
    private String email;

    public NewEmailCommand toNewEmailCommand() {
        return new NewEmailCommand(fullName, email, "Welcome to Maxplorer", String.format("Thanks for subscribing, %s", fullName));
    }
}
