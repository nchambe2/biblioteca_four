import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBookCommandTest  {

    private Library library;
    private ListBookCommand listBookCommand;

    @Before
    public void setUp() {
        library = mock(Library.class);
        listBookCommand = new ListBookCommand(library);
    }

    @Test
    public void shouldListLibraryBooksWhenListBookCommandIsRun() {
        listBookCommand.run();

        verify(library).list();
    }

    @Test
    public void shouldReturnListBooksWhenNameIsCalled() {

        assertThat(listBookCommand.name(), is("List Books"));
    }
}