package br.com.maxplorer.emailservice.adapter.email;

import br.com.maxplorer.emailservice.core.domain.email.Email;
import br.com.maxplorer.emailservice.core.domain.email.EmailSenderPort;
import com.sendgrid.Content;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmailSenderAdapter implements EmailSenderPort {

    private static final Logger LOG = LoggerFactory.getLogger(EmailSenderAdapter.class);

    private final String sendGridKey;

    @Autowired
    public EmailSenderAdapter(@Value(value = "${send-grid.key}") String sendGridKey) {
        this.sendGridKey = sendGridKey;
    }

    @Override
    public void send(Email email) {

        final com.sendgrid.Email from = new com.sendgrid.Email("no-reply@maxplorer.com.br", "Maxplorer");
        final com.sendgrid.Email to = new com.sendgrid.Email(email.to());
        final Content body = new Content("text/plain", email.body());
        final Mail mail = new Mail(from, email.subject(), to, body);
        final SendGrid sendGrid = new SendGrid(sendGridKey);

        try {
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch (IOException e) {
            LOG.error("Failed to send e-mail. \nCause: {} \nMessage: {}", e.getCause(), e.getMessage());
        }
    }
}
