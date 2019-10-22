package br.com.maxplorer.emailservice.core.domain.email;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailTest {

    @Test
    public void shouldReturnNewEmail() {

        final Email newEmail = Email.newEmail("james.gosling@email.com",
                "I want to learn Java",
                "I'm searching for Java lessons");

        assertThat(newEmail).isEqualToComparingFieldByFieldRecursively(EmailTestFixture.newEmail());
    }
}
