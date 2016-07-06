import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LibraryValidatorTest {

    private Library library;
    private Book bookOne;
    private Book bookTwo;
    private Book bookThree;
    private List<Book> checkedInBooks;
    private Input input;
    private LibraryValidator libraryValidator;
    private PrintStream printStream;
    private List<Book> checkedOutBooks;

    @Before
    public void setUp() {
        library = mock(Library.class);
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);
        bookThree = mock(Book.class);
        checkedInBooks = new ArrayList<>();
        checkedInBooks.add(bookOne);
        checkedInBooks.add(bookTwo);
        input = mock(Input.class);
        printStream = mock(PrintStream.class);
        checkedOutBooks = new ArrayList<>();
        checkedOutBooks.add(bookThree);
        libraryValidator = new LibraryValidator(library, input, printStream);
    }

    @Test
    public void shouldGetUserInputWhenValidateMethodIsCalled() {
        when(input.getUserInput()).thenReturn("1");

        libraryValidator.validate(checkedInBooks, checkedOutBooks, successfulCheckoutMessage(), unsuccessfulCheckOutMessage());

        verify(input).getUserInput();

    }

    @Test
    public void shouldCheckoutBookWhenBookSelectedIsCheckedIn() {
        when(input.getUserInput()).thenReturn("1");

        libraryValidator.validate(checkedInBooks, checkedOutBooks, successfulCheckoutMessage(), unsuccessfulReturnMessage());

        verify(library).removeBookFrom(checkedInBooks, checkedOutBooks, 0, successfulCheckoutMessage());
    }


    @Test
    public void shouldDisplayUnsuccessfulCheckoutMessageWhenBookCantBeCheckedOut() {
        when(input.getUserInput()).thenReturn("5");

        libraryValidator.validate(checkedInBooks, checkedOutBooks,successfulCheckoutMessage(), unsuccessfulCheckOutMessage());

        verify(printStream).println(contains(unsuccessfulCheckOutMessage()));
    }


    @Test
    public void shouldReturnBookWhenBookSelectedIsNotCheckedIn() {
        when(input.getUserInput()).thenReturn("1");

        libraryValidator.validate(checkedOutBooks, checkedInBooks, successfulReturnMessage(), unsuccessfulReturnMessage());

        verify(library).removeBookFrom(checkedOutBooks, checkedInBooks, 0, successfulReturnMessage());
    }


    @Test
    public void shouldDisplayUnsuccessfulReturnMessageWhenBookCantBeReturned() {
        when(input.getUserInput()).thenReturn("5");

        libraryValidator.validate(checkedOutBooks, checkedInBooks, successfulReturnMessage(), unsuccessfulReturnMessage());

        verify(printStream).println(contains(unsuccessfulReturnMessage()));
    }

    private String unsuccessfulCheckOutMessage() {
        return "That book can't be checked in.";
    }

    private String unsuccessfulReturnMessage() {
        return "That book can't be returned";
    }


    private String successfulCheckoutMessage() {
        return "Thank you! Enjoy the book";
    }

    private String successfulReturnMessage() {
        return "Thank you for returning the book.";
    }
}
