import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Application {
    private PrintStream printStream;
    private Menu menu;
    private BufferedReader bufferedReader;
    private MenuValidator menuValidator;

    public Application(PrintStream printStream, Menu menu, BufferedReader bufferedReader, MenuValidator menuValidator) {

        this.printStream = printStream;
        this.menu = menu;
        this.bufferedReader = bufferedReader;
        this.menuValidator = menuValidator;
    }

    public void start() {
        String userOption = "";
        printStream.println("Welcome to Biblioteca\n");

        do {
            menu.display();
            userOption = getUserInput();
            menuValidator.validate(userOption);
        } while(!userOption.equals("0"));
    }

    private String getUserInput() {
        String optionSelected = "";
        try {
          optionSelected = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  optionSelected;
    }
}


