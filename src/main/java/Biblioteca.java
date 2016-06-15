import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        List<Book> bookTitles = new ArrayList<>();
        Book parableOfTheSower = new Book(printStream, "Parable of the Sower", "Octavia Butler", "1993");
        Book harryPotter = new Book(printStream, "Harry Potter and the Chamber of Secrets", "JK Rowling", "1999");
        bookTitles.add(parableOfTheSower);
        bookTitles.add(harryPotter);
        Library library = new Library(bookTitles);
        Application application = new Application(printStream, library);
        application.start();
    }
}
