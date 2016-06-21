import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitCommandTest {

    private PrintStream printStream;
    private QuitCommand quitCommand;

    @Test
    public void shouldDisplayGoodbyeWhenQuitCommandIsRun() {
        printStream = mock(PrintStream.class);
        quitCommand = new QuitCommand(printStream);

        quitCommand.run();

        verify(printStream).println(contains("Goodbye"));
    }

    @Test
    public void shouldReturnQuitWhenNameIsCalled() {
        printStream = mock(PrintStream.class);
        quitCommand = new QuitCommand(printStream);

        assertThat(quitCommand.name(), is("Quit"));
    }
}