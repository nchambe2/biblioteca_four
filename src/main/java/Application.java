import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Application {
    private PrintStream printStream;
    private Menu menu;
    private BufferedReader bufferedReader;

    public Application(PrintStream printStream, Menu menu, BufferedReader bufferedReader) {

        this.printStream = printStream;
        this.menu = menu;
        this.bufferedReader = bufferedReader;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca\n");
        menu.display();
        String userOption = getUserInput();
        menu.execute(userOption );
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

//can execute the list library command
// if the selected the right one
//if not it just won't execute anything
