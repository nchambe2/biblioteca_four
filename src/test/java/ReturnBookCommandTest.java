import org.junit.Test;

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
}