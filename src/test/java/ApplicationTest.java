import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private Menu menu;
    private BufferedReader bufferedReader;
    private MenuValidator menuValidator;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        menu = mock(Menu.class);
        bufferedReader = mock(BufferedReader.class);
        menuValidator = mock(MenuValidator.class);
        application = new Application(printStream, menu, bufferedReader, menuValidator);
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
    public void shouldValidateMenuCommandWhenUserInputIsOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");

        application.start();

        verify(menuValidator, atLeast(1)).validate("1");
    }

    @Ignore
    @Test
    public void shouldQuitApplicationWhenUserCommandIsZero() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");

        application.start();
    }

}