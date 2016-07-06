import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookCommandTest {

    private CheckoutBookCommand checkoutBookCommand;
    private LibraryValidator checkoutBookValidator;
    private PrintStream printStream;
    private List<Book> checkedInBooks;
    private List<Book> checkedOutBooks;

    @Before
    public void setUp() {
        checkoutBookValidator = mock(LibraryValidator.class);
        printStream = mock(PrintStream.class);
        checkedInBooks = new ArrayList<>();
        checkedOutBooks = new ArrayList<>();
        checkoutBookCommand = new CheckoutBookCommand(checkoutBookValidator, printStream, checkedInBooks, checkedOutBooks);
    }

    @Test
    public void shouldPromptUserToCheckoutBookWhenCheckoutCommandIsRun() {
        checkoutBookCommand.run();

        verify(printStream).println(contains("the book you want to checkout:"));
    }

    @Test
    public void shouldDisplayCheckoutBookWhenNameIsCalled() {

        assertThat(checkoutBookCommand.name(), is("Checkout Books"));
    }


    @Test
    public void shouldValidateIfBookCanBeCheckedOutWhenCommandIsRun() {
        checkoutBookCommand.run();

        verify(checkoutBookValidator).validate(checkedInBooks, checkedOutBooks, "Thank you! Enjoy the book", "That book can't be checked in.");
    }

}