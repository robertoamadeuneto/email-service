package br.com.maxplorer.emailservice.adapter.jpa.email;

import br.com.maxplorer.emailservice.core.domain.email.EmailControl;
import br.com.maxplorer.emailservice.core.domain.email.EmailControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmailControlRepositoryJpa implements EmailControlRepository {

    private final EmailControlRepositoryJpaSpringData emailControlRepositoryJpaSpringData;

    @Autowired
    public EmailControlRepositoryJpa(EmailControlRepositoryJpaSpringData emailControlRepositoryJpaSpringData) {
        this.emailControlRepositoryJpaSpringData = emailControlRepositoryJpaSpringData;
    }

    @Override
    public void save(EmailControl emailControl) {
        emailControlRepositoryJpaSpringData.save(emailControl);
    }
}
