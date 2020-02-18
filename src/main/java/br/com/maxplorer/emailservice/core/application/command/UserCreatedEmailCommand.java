package br.com.maxplorer.emailservice.core.application.command;

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
public class UserCreatedEmailCommand {

    private String to;
    private String fullName;
}
