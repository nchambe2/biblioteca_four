import java.io.PrintStream;

public class Application {
    private PrintStream printStream;
    private Menu menu;
    private Input input;
    private MenuValidator menuValidator;

    public Application(PrintStream printStream, Menu menu, Input input, MenuValidator menuValidator) {

        this.printStream = printStream;
        this.menu = menu;
        this.input = input;
        this.menuValidator = menuValidator;
    }

    public void start() {
        String userOption = "";
        printStream.println("Welcome to Biblioteca\n");

        do {
            menu.display();
            userOption = input.getUserInput();
            menuValidator.validate(userOption);
        } while(!userOption.equals("0"));
    }

}


