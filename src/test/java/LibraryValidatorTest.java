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
        libraryValidator = new LibraryValidator(library, checkedInBooks, checkedOutBooks, input, printStream);
    }

    @Test
    public void shouldGetUserInputWhenUserHasBeenPromptedToCheckoutABook() {
        when(input.getUserInput()).thenReturn("1");

        libraryValidator.validateIfBookIsCheckedIn();

        verify(input).getUserInput();

    }

    @Test
    public void shouldCheckoutBookWhenBookSelectedIsCheckedIn() {
        when(input.getUserInput()).thenReturn("1");

        libraryValidator.validateIfBookIsCheckedIn();

        verify(library).checkout(0);
    }

    @Test
    public void shouldDisplayUnSuccessfulCheckoutMessageWhenBookSelectedIsNotCheckedIn() {
        when(input.getUserInput()).thenReturn("5");

        libraryValidator.validateIfBookIsCheckedIn();

        verify(printStream).println(contains("book you want to checkout:"));
    }

    @Test
    public void shouldPromptUserToEnterBookTitleWhenReturningABook() {
        when(input.getUserInput()).thenReturn("1");

        libraryValidator.validateIfBookIsCheckedOut();

        verify(printStream).println("Enter the number that corresponds to the book you want to check in:");
    }

    @Test
    public void shouldGetUserInputWhenUserHasBeenPromptedToReturnABook() {
        when(input.getUserInput()).thenReturn("1");

        libraryValidator.validateIfBookIsCheckedOut();

        verify(input).getUserInput();
    }

    @Test
    public void shouldReturnBookIfBookSelectedIsCheckedOut() {
        when(input.getUserInput()).thenReturn("1");

        libraryValidator.validateIfBookIsCheckedOut();

        verify(library).returnBook(0);
    }

    @Test
    public void shouldDisplayUnsuccessfulReturnMessageWhenBookCantBeReturned() {
        when(input.getUserInput()).thenReturn("5");

        libraryValidator.validateIfBookIsCheckedIn();

        verify(printStream).println(contains("That is not a valid book to return."));
    }

}