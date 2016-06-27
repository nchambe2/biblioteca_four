import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CheckoutBookValidatorTest {

    private Library library;
    private Book bookOne;
    private Book bookTwo;
    private List<Book> checkedInBooks;
    private Input input;
    private CheckoutBookValidator checkoutBookValidator;
    private PrintStream printStream;

    @Before
    public void setUp() {
        library = mock(Library.class);
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);
        checkedInBooks = new ArrayList<>();
        checkedInBooks.add(bookOne);
        checkedInBooks.add(bookTwo);
        input = mock(Input.class);
        printStream = mock(PrintStream.class);
        checkoutBookValidator = new CheckoutBookValidator(library, checkedInBooks, input, printStream);
    }

    @Test
    public void shouldListCheckedInBooksWhenValidateMethodIsInvoked() {
        when(input.getUserInput()).thenReturn("1");

        checkoutBookValidator.validate();

        verify(library).listCheckedInBooks();
    }

    @Test
    public void shouldGetUserInputWhenValidateMethodIsInvoked() {
        when(input.getUserInput()).thenReturn("1");

        checkoutBookValidator.validate();

        verify(input).getUserInput();

    }

    @Test
    public void shouldCheckoutBookWhenBookSelectedIsCheckedIn() {
        when(input.getUserInput()).thenReturn("1");

        checkoutBookValidator.validate();

        verify(library).checkout(0);
    }

    @Test
    public void shouldDisplayUnSuccessfulCheckoutMessageWhenBookSelectedIsNotCheckedIn() {
        when(input.getUserInput()).thenReturn("5");

        checkoutBookValidator.validate();

        verify(printStream).println("That book is not available.");
    }

}