import java.io.PrintStream;
import java.util.Map;

public class Menu {
    private PrintStream printStream;
    private Library library;
    private Map<Integer, String> menuOptions;
    private Map<String, Command> libraryCommands;
    private final static String QUIT_OPTION = "0";
    private final static String LIST_BOOK_OPTION= "1";

    public Menu(PrintStream printStream, Library library, Map<Integer, String> menuOptions, Map<String, Command> libraryCommands) {
        this.printStream = printStream;
        this.library = library;
        this.menuOptions = menuOptions;
        this.libraryCommands = libraryCommands;
    }

    public void display() {
        for(Map.Entry<Integer, String> menuOption : menuOptions.entrySet()) {
            printStream.println(menuOption.getKey() + ". " + menuOption.getValue() + "\n");
        }
    }

    public void execute(String userSelection) {

        if(isListBookOption(userSelection)) {
            library.list();
        } else if (isQuitOption(userSelection)){
            printStream.println("Goodbye");
        } else {
            printStream.println("Select a valid option!");
        }
    }

    private boolean isListBookOption(String userSelection) {
        return userSelection.equals(LIST_BOOK_OPTION);
    }

    private boolean isQuitOption(String userSelection) {
        return userSelection.equals(QUIT_OPTION);
    }

    public void executex(String userSelection) {
       libraryCommands.get(userSelection).run();
    }


    //want to iterate over the menuCommands
    //in execute take in the user selection
    //if the userSelection maps to a key in libray commands
    //run that library command
    //else print select a valid option

}
