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

    public static Email newEmail(String to,
                                 String subject,
                                 String body) {
        return new Email(to, subject, body);
    }
}