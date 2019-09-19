package br.com.maxplorer.emailservice.core.domain.exception;

public class InternalServerException extends RuntimeException {

    public InternalServerException(String message) {
        super(message);
    }
}
