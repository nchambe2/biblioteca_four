import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuValidatorTest {

    private Menu menu;
    private PrintStream printStream;
    private Map<String, Command> libraryCommands;
    private MenuValidator menuValidator;
    private ListBookCommand listBookCommand;

    @Before
    public void setUp() {
        menu = mock(Menu.class);
        printStream = mock(PrintStream.class);
        libraryCommands = new HashMap<>();
        listBookCommand = mock(ListBookCommand.class);
        libraryCommands.put("1", listBookCommand);
        menuValidator = new MenuValidator(menu, printStream, libraryCommands);
    }

    @Test
    public void shouldDisplaySelectionInvalidMessageWhenUserSelectionIsNotAValidCommand() {
        menuValidator.validate(anyString());

        verify(printStream).println("Select a valid option");
    }

    @Test
    public void shouldExecuteMenuCommandWhenUserSelectionIsValid() {
        menuValidator.validate("1");

        verify(menu).execute(anyString());
    }
}