package br.com.maxplorer.emailservice.core.application;

import br.com.maxplorer.emailservice.core.application.command.UserCreatedEmailCommand;
import br.com.maxplorer.emailservice.core.domain.email.Email;
import br.com.maxplorer.emailservice.core.domain.email.EmailControl;
import br.com.maxplorer.emailservice.core.domain.email.EmailControlRepository;
import br.com.maxplorer.emailservice.core.domain.email.EmailSenderPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailApplicationService {

    private final EmailSenderPort emailSenderPort;
    private final EmailControlRepository emailControlRepository;

    public void sendUserCreatedEmail(final UserCreatedEmailCommand command) {
        final EmailControl emailControl = EmailControl.newEmailControl(command.to(), command.fullName());

        emailControlRepository.save(emailControl);

        final Email email = Email.newUserCreatedEmail(command.to(), command.fullName());

        emailSenderPort.send(email);
    }
}
