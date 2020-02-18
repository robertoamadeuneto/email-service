package br.com.maxplorer.emailservice.adapter.email;

import br.com.maxplorer.emailservice.core.domain.exception.InternalServerException;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmailSenderAdapter.class)
public class EmailSenderAdapterTest {

    @Mock
    private SendGrid sendGrid;

    private EmailSenderAdapter emailSenderAdapter;

    @Before
    public void setUp() throws Exception {
        whenNew(SendGrid.class).withAnyArguments().thenReturn(sendGrid);
        emailSenderAdapter = new EmailSenderAdapter("SG.UpOOWpWGBwMVpE1d8$dz#qtXG4Q#*gFHlIPth88smkldOhO@c2");
    }

    @Test
    public void shouldSendEmail() throws Exception {

        when(sendGrid.api(any())).thenReturn(new Response());

        emailSenderAdapter.send(EmailSenderAdapterTestFixture.email());

        verify(sendGrid).api(any());
    }

//    @Test
//    public void shouldFailTryingToSendEmail() throws Exception {
//
//        when(sendGrid.api(any())).thenThrow(IOException.class);
//
//        assertThatThrownBy(() -> emailSenderAdapter.send(EmailSenderAdapterTestFixture.email()))
//                .isInstanceOf(InternalServerException.class);
//    }
}
