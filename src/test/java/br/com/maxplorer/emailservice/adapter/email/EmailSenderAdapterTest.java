package br.com.maxplorer.emailservice.adapter.email;

import br.com.maxplorer.emailservice.core.domain.exception.InternalServerException;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmailSenderAdapterTest {

    @Mock
    private SendGrid sendGrid;

    private EmailSenderAdapter emailSenderAdapter;

    @Before
    public void setUp() {
        emailSenderAdapter = new EmailSenderAdapter(sendGrid);
    }

    @Test
    public void shouldSendEmail() throws Exception {

        when(sendGrid.api(any())).thenReturn(new Response());

        emailSenderAdapter.send(EmailSenderAdapterTestFixture.email());

        verify(sendGrid).api(any());
    }

    @Test
    public void shouldFailTryingToSendEmail() throws Exception {

        when(sendGrid.api(any())).thenThrow(IOException.class);

        assertThatThrownBy(() -> emailSenderAdapter.send(EmailSenderAdapterTestFixture.email()))
                .isInstanceOf(InternalServerException.class);
    }
}
