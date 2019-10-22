package br.com.maxplorer.emailservice.core.application;

import br.com.maxplorer.emailservice.core.application.command.NewEmailCommand;
import br.com.maxplorer.emailservice.core.domain.email.Email;
import br.com.maxplorer.emailservice.core.domain.email.EmailSenderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailApplicationService {

    private EmailSenderPort emailSenderPort;

    @Autowired
    public EmailApplicationService(EmailSenderPort emailSenderPort) {
        this.emailSenderPort = emailSenderPort;
    }

    public void sendNewEmail(NewEmailCommand command) {
        emailSenderPort.send(Email.newEmail(command.to(), command.subject(), command.body()));
    }
}
