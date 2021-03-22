package br.com.maxplorer.emailservice.adapter.email;

import br.com.maxplorer.emailservice.core.domain.email.Email;
import br.com.maxplorer.emailservice.core.domain.email.EmailSenderPort;
import com.sendgrid.Content;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class EmailSenderAdapter implements EmailSenderPort {

    private final String sendGridKey;

    @Autowired
    public EmailSenderAdapter(@Value(value = "${send-grid.key}") String sendGridKey) {
        this.sendGridKey = sendGridKey;
    }

    @Override
    public void send(final Email email) {
        final com.sendgrid.Email from = new com.sendgrid.Email("no-reply@maxplorer.com.br", "Maxplorer");
        final com.sendgrid.Email to = new com.sendgrid.Email(email.to());
        final Content body = new Content("text/plain", email.body());
        final Mail mail = new Mail(from, email.subject(), to, body);
        final SendGrid sendGrid = new SendGrid(sendGridKey);

        try {
            final Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch (IOException e) {
            log.error("Failed to send e-mail. \nCause: {} \nMessage: {}", e.getCause(), e.getMessage());
        }
    }
}
