import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        List<String> booksInTheLibrary = new ArrayList<>();
        booksInTheLibrary.add("The Parable of the Sower");
        booksInTheLibrary.add("Harry Potter and the Chamber of the Secrets");
        Application application = new Application(printStream, booksInTheLibrary);
        application.start();
    }
}
