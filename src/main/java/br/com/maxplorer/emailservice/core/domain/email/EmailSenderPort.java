package br.com.maxplorer.emailservice.core.domain.email;

public interface EmailSenderPort {

    void send(Email email);
}
