import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private Menu menu;
    private PrintStream printStream;
    private Library library;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        menu = new Menu(printStream, library);
    }


    @Test
    public void shouldPrintListBooksOptionWhenMenuIsDisplayed(){
        menu.display();

        verify(printStream).println(contains("List"));
    }

    @Test
    public void shouldExecuteListBookOptionWhenUserSelectionIsOne(){
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        menu = new Menu(printStream, library);

        menu.execute("1");

        verify(library).list();
    }


}