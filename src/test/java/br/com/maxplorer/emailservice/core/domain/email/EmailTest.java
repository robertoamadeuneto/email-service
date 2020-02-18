package br.com.maxplorer.emailservice.core.domain.email;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailTest {

    @Test
    public void shouldReturnNewEmail() {

        final Email newUserCreatedEmail = Email.newUserCreatedEmail("james.gosling@email.com", "James Gosling");

        assertThat(newUserCreatedEmail).isEqualToComparingFieldByFieldRecursively(EmailTestFixture.newUserCreatedEmail());
    }
}
