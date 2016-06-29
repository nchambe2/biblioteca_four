import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBookCommandTest {
    @Test
    public void shouldReturnBookWhenRunCommandIsExecuted() {
        LibraryValidator libraryValidator = mock(LibraryValidator.class);
        ReturnBookCommand returnBookCommand = new ReturnBookCommand(libraryValidator);

        returnBookCommand.run();

        verify(libraryValidator).validateIfBookIsCheckedOut();
    }

    @Test
    public void shouldDisplayReturnBookWhenNameIsCalled() {
        LibraryValidator libraryValidator = mock(LibraryValidator.class);
        ReturnBookCommand returnBookCommand = new ReturnBookCommand(libraryValidator);

        assertThat(returnBookCommand.name(), is("Return Book"));
    }
}