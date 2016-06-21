import java.io.PrintStream;
import java.util.Map;

public class Menu {
    private PrintStream printStream;
    private Map<String, Command> libraryCommands;

    public Menu(PrintStream printStream, Map<String, Command> libraryCommands) {
        this.printStream = printStream;
        this.libraryCommands = libraryCommands;
    }

    public void display() {
        for(String key : libraryCommands.keySet()) {
            printStream.println(key + ". " + libraryCommands.get(key).name() + "\n");
        }
    }

    public void execute(String userSelection) {
        libraryCommands.get(userSelection).run();
    }
}
