package br.com.maxplorer.emailservice.adapter.jpa.email;

import br.com.maxplorer.emailservice.core.domain.email.EmailControl;
import br.com.maxplorer.emailservice.core.domain.email.EmailControlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class EmailControlRepositoryJpa implements EmailControlRepository {

    private final EmailControlRepositoryJpaSpringData emailControlRepositoryJpaSpringData;

    @Override
    public void save(final EmailControl emailControl) {
        emailControlRepositoryJpaSpringData.save(emailControl);
    }
}
