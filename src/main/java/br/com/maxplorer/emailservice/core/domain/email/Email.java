package br.com.maxplorer.emailservice.core.domain.email;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Accessors(fluent = true)
public class Email {

    private String to;
    private String subject;
    private String body;

    public static Email newUserCreatedEmail(String to, String fullName) {
        return new Email(to, "Welcome to Maxplorer", String.format("Thanks for subscribing, %s", fullName));
    }
}
