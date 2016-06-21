import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBookCommandTest  {
    @Test
    public void shouldListLibraryBooksWhenListBookCommandIsRun() {
        Library library = mock(Library.class);
        Command listBookCommand = new ListBookCommand(library);

        listBookCommand.run();

        verify(library).list();
    }
}