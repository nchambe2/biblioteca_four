import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookCommandTest {

    private Library library;
    private CheckoutBookCommand checkoutBookCommand;

    @Before
    public void setUp() {
        library = mock(Library.class);
        checkoutBookCommand = new CheckoutBookCommand(library);
    }

    @Test
    public void shouldDisplayCheckoutBookWhenNameIsCalled() {
        library = mock(Library.class);
        checkoutBookCommand = new CheckoutBookCommand(library);

        assertThat(checkoutBookCommand.name(), is("Checkout Books"));
    }

    @Test
    public void shouldCheckoutBookWhenCommandisRun() {
        library = mock(Library.class);
        checkoutBookCommand = new CheckoutBookCommand(library);

        checkoutBookCommand.run();

        verify(library).checkout();
    }
}