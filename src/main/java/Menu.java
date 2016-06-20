import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Map;

public class Menu {
    private PrintStream printStream;
    private Library library;
    private Map<Integer, String> menuOptions;
    private final static String QUIT_OPTION = "0";
    private final static String LIST_BOOK_OPTION= "1";

    public Menu(PrintStream printStream, Library library, Map<Integer, String> menuOptions, BufferedReader bufferedReader) {

        this.printStream = printStream;
        this.library = library;
        this.menuOptions = menuOptions;
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

    //want to continue choosing option until quit is chosen
    //quit needs to be added to the menu - done
    //0 needs to be a user selection - done
    //where should quit live??
    //technically it could live in application
    //however don't want to inject application into menu
    //need a loop that going = last
    //refactor list books menu test to List book
    //get user input from menu validator
    //validates user input
    //if valid sends it to menu
    //else prints message
}
