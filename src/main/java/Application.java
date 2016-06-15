import java.io.PrintStream;

public class Application {
    private PrintStream printStream;
    private Library library;

    public Application(PrintStream printStream, Library library) {

        this.printStream = printStream;
        this.library = library;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca\n");
        library.list();
    }
}
