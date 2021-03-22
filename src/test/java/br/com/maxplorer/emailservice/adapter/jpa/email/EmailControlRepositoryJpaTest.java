package br.com.maxplorer.emailservice.adapter.jpa.email;

import br.com.maxplorer.emailservice.core.domain.email.EmailControl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmailControlRepositoryJpaTest {

    @Mock
    private EmailControlRepositoryJpaSpringData emailControlRepositoryJpaSpringData;

    private EmailControlRepositoryJpa emailControlRepositoryJpa;

    @Before
    public void setUp() {
        emailControlRepositoryJpa = new EmailControlRepositoryJpa(emailControlRepositoryJpaSpringData);
    }

    @Test
    public void shouldSave() {
        final EmailControl emailControl = EmailControlRepositoryJpaTestFixture.emailControl();

        emailControlRepositoryJpa.save(emailControl);

        verify(emailControlRepositoryJpaSpringData).save(same(emailControl));
    }
}
