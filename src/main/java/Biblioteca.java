import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Biblioteca {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        List<Book> bookTitles = new ArrayList<>();
        Book parableOfTheSower = new Book(printStream, "Parable of the Sower", "Octavia Butler", "1993");
        Book harryPotter = new Book(printStream, "Harry Potter and the Chamber of Secrets", "JK Rowling", "1999");
        bookTitles.add(parableOfTheSower);
        bookTitles.add(harryPotter);
        Library library = new Library(bookTitles);
        Map<Integer, String> menuCommands = new LinkedHashMap<>();
        menuCommands.put(0, "Quit");
        menuCommands.put(1, "List Books");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Command> libraryCommands = new HashMap<>();
        Command listBookCommand = new ListBookCommand(library);
        libraryCommands.put("1", listBookCommand);
        Menu menu = new Menu(printStream, library, menuCommands, libraryCommands);
        Application application = new Application(printStream, menu, bufferedReader);

        application.start();
    }
}

