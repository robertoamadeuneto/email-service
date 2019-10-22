package br.com.maxplorer.emailservice.adapter.email;

import br.com.maxplorer.emailservice.core.domain.email.Email;
import br.com.maxplorer.emailservice.core.domain.email.EmailSenderPort;
import br.com.maxplorer.emailservice.core.domain.exception.InternalServerException;
import com.sendgrid.Content;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmailSenderAdapter implements EmailSenderPort {

    private static final Logger LOG = LoggerFactory.getLogger(EmailSenderAdapter.class);

    private SendGrid sendGrid;

    @Autowired
    public EmailSenderAdapter(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    @Override
    public void send(Email email) {

        final com.sendgrid.Email from = new com.sendgrid.Email("no-reply@maxplorer.com.br", "Maxplorer");
        final com.sendgrid.Email to = new com.sendgrid.Email(email.to());
        final Content body = new Content("text/plain", email.body());
        final Mail mail = new Mail(from, email.subject(), to, body);
        //final SendGrid sendGrid = new SendGrid("");

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch (IOException e) {
            LOG.error("Failed to send e-mail. \nCause: {} \nMessage: {}", e.getCause(), e.getMessage());
            throw new InternalServerException(e.getMessage());
        }
    }
}
