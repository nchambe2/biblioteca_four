import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Biblioteca {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Book parableOfTheSower = new Book("Parable of the Sower", "Octavia Butler", "1993");
        Book harryPotter = new Book("Harry Potter and the Chamber of Secrets", "JK Rowling", "1999");
        Book gameOfThrones = new Book("Game of Thrones", "George R.R. Martin", "1996");
        List<Book> checkedInBooks = new ArrayList<>();
        List<Book> checkedOutBooks = new ArrayList<>();
        checkedInBooks.add(parableOfTheSower);
        checkedInBooks.add(harryPotter);
        checkedOutBooks.add(gameOfThrones);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input(bufferedReader);
        Library library = new Library(checkedInBooks, printStream);
        Map<String, Command> libraryCommands = new HashMap<>();
        Command quitCommand = new QuitCommand(printStream);
        Command listBookCommand = new ListBookCommand(library);
        LibraryValidator libraryValidator = new LibraryValidator(library, input, printStream);
        Command checkoutBookCommand = new CheckoutBookCommand(libraryValidator, printStream, checkedInBooks, checkedOutBooks);
        Command returnBookCommand = new ReturnBookCommand(libraryValidator, printStream, checkedOutBooks, checkedInBooks);
        libraryCommands.put("0", quitCommand);
        libraryCommands.put("1", listBookCommand);
        libraryCommands.put("2", checkoutBookCommand);
        libraryCommands.put("3", returnBookCommand);
        Menu menu = new Menu(printStream, libraryCommands);
        MenuValidator menuValidator = new MenuValidator(menu, printStream, libraryCommands);
        Application application = new Application(printStream, menu, input, menuValidator);

        application.start();
    }
}

