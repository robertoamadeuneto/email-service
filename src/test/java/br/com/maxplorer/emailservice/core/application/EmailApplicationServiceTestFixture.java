package br.com.maxplorer.emailservice.core.application;

import br.com.maxplorer.emailservice.core.application.command.NewEmailCommand;
import br.com.maxplorer.emailservice.core.domain.email.Email;

class EmailApplicationServiceTestFixture {

    private EmailApplicationServiceTestFixture() {
    }

    static NewEmailCommand newEmailCommand() {
        return new NewEmailCommand("James Gosling",
                "james.gosling@email.com",
                "I want to learn Java",
                "I'm searching for Java lessons");
    }

    static Email email() {
        return new Email("james.gosling@email.com",
                "I want to learn Java",
                "I'm searching for Java lessons");
    }
}
