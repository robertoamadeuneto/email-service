package br.com.maxplorer.emailservice.core.domain.email;

class EmailTestFixture {

    private EmailTestFixture() {
    }

    static Email newUserCreatedEmail() {
        return new Email("james.gosling@email.com",
                "Welcome to Maxplorer",
                "Thanks for subscribing, James Gosling");
    }
}
