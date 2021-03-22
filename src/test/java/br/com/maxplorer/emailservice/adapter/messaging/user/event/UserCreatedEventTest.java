package br.com.maxplorer.emailservice.adapter.messaging.user.event;

import br.com.maxplorer.emailservice.core.application.command.UserCreatedEmailCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCreatedEventTest {

    @Test
    public void shouldReturnNewEmailCommand() {
        final UserCreatedEmailCommand userCreatedEmailCommand = UserCreatedEventTestFixture.userCreatedEvent().toUserCreatedEmailCommand();

        assertThat(userCreatedEmailCommand).isEqualToComparingFieldByFieldRecursively(UserCreatedEventTestFixture.newEmailCommand());
    }
}
