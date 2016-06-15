import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private Library library;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        application = new Application(printStream, library);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStarts() {
        application.start();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldListLibraryBookTitlesWhenWelcomeMessageHasBeenDisplayed() {
        application.start();

        verify(library).list();
    }

}