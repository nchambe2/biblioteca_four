import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookCommandTest {

    private Library library;
    private CheckoutBookCommand checkoutBookCommand;
    private CheckoutBookValidator checkoutBookValidator;

    @Before
    public void setUp() {
        library = mock(Library.class);
        checkoutBookValidator = mock(CheckoutBookValidator.class);
        checkoutBookCommand = new CheckoutBookCommand(library, checkoutBookValidator);
    }

    @Test
    public void shouldDisplayCheckoutBookWhenNameIsCalled() {
        library = mock(Library.class);
        checkoutBookCommand = new CheckoutBookCommand(library, checkoutBookValidator);

        assertThat(checkoutBookCommand.name(), is("Checkout Books"));
    }

    @Test
    public void shouldCheckoutBookWhenCommandIsRun() {
        library = mock(Library.class);
        checkoutBookCommand = new CheckoutBookCommand(library, checkoutBookValidator);

        checkoutBookCommand.run();

        verify(library).checkout(1);
    }

    @Test
    public void shouldCheckoutBookWhenCommandIsRunX() {
        library = mock(Library.class);
        checkoutBookCommand = new CheckoutBookCommand(library, checkoutBookValidator);

        checkoutBookCommand.run();

        verify(checkoutBookValidator).validate();
    }
}