package br.com.maxplorer.emailservice.core.domain.email;

class EmailTestFixture {

    private EmailTestFixture() {
    }

    static Email newEmail() {
        return new Email("james.gosling@email.com",
                "I want to learn Java",
                "I'm searching for Java lessons");
    }
}
