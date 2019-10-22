package br.com.maxplorer.emailservice.adapter.email;

import br.com.maxplorer.emailservice.core.domain.email.Email;

class EmailSenderAdapterTestFixture {

    private EmailSenderAdapterTestFixture() {
    }

    static Email email() {
        return new Email("james.gosling@email.com",
                "I want to learn Java",
                "I'm searching for Java lessons");
    }
}
