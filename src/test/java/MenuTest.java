import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    private Menu menu;
    private PrintStream printStream;
    private Library library;
    private Map<Integer,String> menuOptions;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        bufferedReader = mock(BufferedReader.class);
        menuOptions = new LinkedHashMap<>();
        menu = new Menu(printStream, library, menuOptions, bufferedReader);
    }


    @Test
    public void shouldPrintQuitOptionWhenMenuIsDisplayed() {
        menuOptions.put(0, "Quit");

        menu.display();

        verify(printStream).println(contains("Quit"));
    }

    @Test
    public void shouldPrintListBooksOptionWhenMenuIsDisplayed(){
        menuOptions.put(1, "List Books");

        menu.display();

        verify(printStream).println(contains("List Books"));
    }

    @Test
    public void shouldExecuteListBookOptionWhenUserSelectionIsOne() throws IOException {
        menu.execute("1");

        verify(library).list();
    }

    @Test
    public void shouldDisplayInvalidOptionMessageWhenUserSelectionIsNotOne(){
        menu.execute("jdlkfsjk");

        verify(printStream).println(contains("Select a valid option"));
    }

    @Test
    public void shouldDisplayGoodbyeMessageWhenUserEntersZero() {
        menu.execute("0");

        verify(printStream).println(contains("Goodbye"));
    }

}