import java.io.PrintStream;
import java.util.List;

public class Application {
    private PrintStream printStream;
    private List<String> booksInTheLibrary;

    public Application(PrintStream printStream, List<String> booksInTheLibrary) {
        this.printStream = printStream;
        this.booksInTheLibrary = booksInTheLibrary;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca");

        for(String bookTitle : booksInTheLibrary){
            printStream.println(bookTitle + "\n");
        }
    }
}
