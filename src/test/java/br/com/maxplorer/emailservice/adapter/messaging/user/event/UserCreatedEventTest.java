package br.com.maxplorer.emailservice.adapter.messaging.user.event;

import br.com.maxplorer.emailservice.core.application.command.NewEmailCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCreatedEventTest {

    @Test
    public void shouldReturnNewEmailCommand() {

        final NewEmailCommand newEmailCommand = UserCreatedEventTestFixture.userCreatedEvent().toNewEmailCommand();

        assertThat(newEmailCommand).isEqualToComparingFieldByFieldRecursively(UserCreatedEventTestFixture.newEmailCommand());
    }
}
