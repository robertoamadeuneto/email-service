package br.com.maxplorer.emailservice.adapter.jpa.email;

import br.com.maxplorer.emailservice.core.domain.email.EmailControl;

import java.time.LocalDateTime;

class EmailControlRepositoryJpaTestFixture {

    private EmailControlRepositoryJpaTestFixture() {
    }

    static EmailControl emailControl() {
        return new EmailControl("james.gosling@email.com",
                "James Gosling",
                "2ad94a172d8150844be8475c9e146a0d",
                true,
                LocalDateTime.now());
    }
}
