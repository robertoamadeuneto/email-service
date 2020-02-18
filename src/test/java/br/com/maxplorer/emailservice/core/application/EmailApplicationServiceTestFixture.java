package br.com.maxplorer.emailservice.core.application;

import br.com.maxplorer.emailservice.core.application.command.UserCreatedEmailCommand;
import br.com.maxplorer.emailservice.core.domain.email.Email;

class EmailApplicationServiceTestFixture {

    private EmailApplicationServiceTestFixture() {
    }

    static UserCreatedEmailCommand userCreatedEmailCommand() {
        return new UserCreatedEmailCommand("james.gosling@email.com", "James Gosling");
    }

    static Email email() {
        return new Email("james.gosling@email.com",
                "Welcome to Maxplorer",
                "Thanks for subscribing, James Gosling");
    }
}
