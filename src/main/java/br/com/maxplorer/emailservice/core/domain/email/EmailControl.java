package br.com.maxplorer.emailservice.core.domain.email;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Document(collection = "email_control")
public class EmailControl {

    @Id
    private String email;
    private String fullName;
    private String hash;
    private Boolean active;
    private LocalDateTime validUntil;
}
