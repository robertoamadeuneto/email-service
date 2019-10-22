package br.com.maxplorer.emailservice;

import br.com.maxplorer.emailservice.adapter.messaging.MessagingChannels;
import com.sendgrid.SendGrid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBinding(value = MessagingChannels.class)
public class EmailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }

    @Bean
    public SendGrid sendGrid() {
        return new SendGrid("");
    }
}
