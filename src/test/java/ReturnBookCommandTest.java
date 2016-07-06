import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBookCommandTest {

    private LibraryValidator libraryValidator;
    private ReturnBookCommand returnBookCommand;
    private PrintStream printStream;
    private List<Book> checkedOutBooks;
    private List<Book> checkedInBooks;

    @Before
    public void setUp() {
        libraryValidator = mock(LibraryValidator.class);
        printStream = mock(PrintStream.class);
        checkedOutBooks = new ArrayList<>();
        checkedInBooks = new ArrayList<>();
        returnBookCommand = new ReturnBookCommand(libraryValidator, printStream, checkedOutBooks, checkedInBooks);
    }

    @Test
    public void shouldPromptUserToReturnBookWhenCommandIsRun() {
        returnBookCommand.run();

        verify(printStream).println(contains("Enter the number that corresponds to the book you want to return:"));
    }


    @Test
    public void shouldValidateIfBookCanBeReturnedWhenCommandIsCalled() {
        returnBookCommand.run();

        verify(libraryValidator).validate(checkedOutBooks, checkedInBooks, "Thank you for returning the book.", "This book can not be returned");
    }

    @Test
    public void shouldDisplayReturnBookWhenNameIsCalled() {

        assertThat(returnBookCommand.name(), is("Return Book"));
    }
}