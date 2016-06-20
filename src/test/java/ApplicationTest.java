import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private Menu menu;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        menu = mock(Menu.class);
        bufferedReader = mock(BufferedReader.class);
        application = new Application(printStream, menu, bufferedReader);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStarts() {
        application.start();

        verify(printStream).println(contains("Welcome"));
    }


    @Test
    public void shouldDisplayMenuOptionWhenWelcomeMessageHasBeenDisplayed() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");

        application.start();

        verify(menu).display();
    }

    @Test
    public void shouldExecuteMenuCommandWhenUserEntersASelection() throws IOException {
        when(bufferedReader.readLine()).thenReturn("jfklsdja");

        application.start();

        verify(menu).execute("jfklsdja");
    }

    @Ignore
    @Test
    public void shouldQuitApplicationWhenUserCommandIsZero() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");

        application.start();
    }

}