package br.com.maxplorer.emailservice.adapter.jpa.email;

import br.com.maxplorer.emailservice.core.domain.email.EmailControl;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailControlRepositoryJpaSpringData extends MongoRepository<EmailControl, String> {

}
