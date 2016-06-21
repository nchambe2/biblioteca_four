import java.io.PrintStream;
import java.util.Map;

public class MenuValidator {
    private Menu menu;
    private PrintStream printStream;
    private Map<String, Command> libraryCommands;

    public MenuValidator(Menu menu, PrintStream printStream, Map<String, Command> libraryCommands) {
        this.menu = menu;
        this.printStream = printStream;
        this.libraryCommands = libraryCommands;
    }

    public void validate(String userSelection) {
        if(libraryCommands.containsKey(userSelection)) {
            menu.execute(userSelection);
        } else {
            printStream.println("Select a valid option");
        }
    }
}
