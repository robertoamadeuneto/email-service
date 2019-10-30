package br.com.maxplorer.emailservice;

import org.junit.Test;

public class EmailServiceApplicationTest {

    @Test
    public void shouldStartEmailServiceApplication() {
        EmailServiceApplication.main(new String[]{
                "--spring.rabbitmq.addresses=address",
                "--spring.rabbitmq.username=username",
                "--spring.rabbitmq.password=password",
                "--sendgrid.key=key"
        });
    }
}
