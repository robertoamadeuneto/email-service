package br.com.maxplorer.emailservice.core.application;

import br.com.maxplorer.emailservice.core.domain.email.EmailSenderPort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmailApplicationServiceTest {

    @Mock
    private EmailSenderPort emailSenderPort;

    private EmailApplicationService emailApplicationService;

    @Before
    public void setUp() {
        emailApplicationService = new EmailApplicationService(emailSenderPort);
    }

    @Test
    public void shouldSendNewEmail() {

        emailApplicationService.sendNewEmail(EmailApplicationServiceTestFixture.newEmailCommand());

        verify(emailSenderPort).send(EmailApplicationServiceTestFixture.email());
    }
}
