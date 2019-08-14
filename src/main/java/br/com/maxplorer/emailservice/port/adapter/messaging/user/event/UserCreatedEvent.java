package br.com.maxplorer.emailservice.port.adapter.messaging.user.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class UserCreatedEvent {

    private UUID id;
    private String fullName;
    private String email;
}
