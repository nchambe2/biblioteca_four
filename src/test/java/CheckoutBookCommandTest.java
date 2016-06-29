import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookCommandTest {

    private CheckoutBookCommand checkoutBookCommand;
    private LibraryValidator checkoutBookValidator;

    @Before
    public void setUp() {
        checkoutBookValidator = mock(LibraryValidator.class);
        checkoutBookCommand = new CheckoutBookCommand(checkoutBookValidator);
    }

    @Test
    public void shouldDisplayCheckoutBookWhenNameIsCalled() {

        assertThat(checkoutBookCommand.name(), is("Checkout Books"));
    }

    @Test
    public void shouldCheckoutBookWhenCommandIsRun() {
        checkoutBookCommand.run();

        verify(checkoutBookValidator).validateIfBookIsCheckedIn();
    }
}