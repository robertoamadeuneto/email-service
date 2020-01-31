package br.com.maxplorer.emailservice.core.application;

import br.com.maxplorer.emailservice.core.application.command.NewEmailCommand;
import br.com.maxplorer.emailservice.core.domain.email.Email;
import br.com.maxplorer.emailservice.core.domain.email.EmailControl;
import br.com.maxplorer.emailservice.core.domain.email.EmailControlRepository;
import br.com.maxplorer.emailservice.core.domain.email.EmailSenderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class EmailApplicationService {

    private EmailSenderPort emailSenderPort;
    private EmailControlRepository emailControlRepository;

    @Autowired
    public EmailApplicationService(EmailSenderPort emailSenderPort,
                                   EmailControlRepository emailControlRepository) {
        this.emailSenderPort = emailSenderPort;
        this.emailControlRepository = emailControlRepository;
    }

    public void sendUserCreatedEvent(NewEmailCommand command) {

        emailSenderPort.send(Email.newEmail(command.to(), command.subject(), command.body()));

        emailControlRepository.save(new EmailControl(command.to(), command.fullName(), UUID.randomUUID().toString(), true, OffsetDateTime.now().plusDays(1)));
    }
}
