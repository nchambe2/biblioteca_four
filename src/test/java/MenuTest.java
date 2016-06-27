import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class MenuTest {
    private Menu menu;
    private PrintStream printStream;
    private Map<String, Command> libraryCommands;
    private Command listBookCommand;
    private Command quitCommand;
    private Command checkoutBookCommand;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        libraryCommands = new HashMap<>();
        listBookCommand = mock(ListBookCommand.class);
        quitCommand = mock(QuitCommand.class);
        checkoutBookCommand = mock(CheckoutBookCommand.class);
        libraryCommands.put("0", quitCommand);
        libraryCommands.put("1", listBookCommand);
        libraryCommands.put("2", checkoutBookCommand);
        menu = new Menu(printStream, libraryCommands);
    }


    @Test
    public void shouldPrintQuitOptionWhenMenuIsDisplayed() {
        when(quitCommand.name()).thenReturn("Quit");

        menu.display();

        verify(printStream).println(contains("Quit"));
    }


    @Test
    public void shouldPrintListBooksOptionWhenMenuIsDisplayed(){
        when(listBookCommand.name()).thenReturn("List Books");

        menu.display();

        verify(printStream).println(contains("List Books"));
    }

    @Test
    public void shouldPrintCheckoutBookOptionWhenMenuIsDisplayed(){
        when(checkoutBookCommand.name()).thenReturn("Checkout Books");

        menu.display();

        verify(printStream).println(contains("Checkout Books"));
    }

    @Test
    public void shouldExecuteQuitCommandWhenUserSelectionIsZero() {
        menu.execute("0");

        verify(quitCommand).run();
    }

    @Test
    public void shouldExecuteListBookCommandWhenUserSelectionIsOne() {
        menu.execute("1");

        verify(listBookCommand).run();
    }

}