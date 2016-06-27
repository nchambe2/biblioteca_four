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
        Map<String, Book> checkedInBooks = new HashMap<>();
        checkedInBooks.put("1", parableOfTheSower);
        checkedInBooks.put("2", harryPotter);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library(checkedInBooks, bufferedReader, printStream);
        Map<String, Command> libraryCommands = new HashMap<>();
        Command quitCommand = new QuitCommand(printStream);
        Command listBookCommand = new ListBookCommand(library);
        Command checkoutBookCommand = new CheckoutBookCommand(library);
        libraryCommands.put("0", quitCommand);
        libraryCommands.put("1", listBookCommand);
        libraryCommands.put("2", checkoutBookCommand);
        Menu menu = new Menu(printStream, libraryCommands);
        MenuValidator menuValidator = new MenuValidator(menu, printStream, libraryCommands);
        Application application = new Application(printStream, menu, bufferedReader, menuValidator);

        application.start();

        //user can check out a book
        //add it as a library command - done
        //have it display in the menu - done
        //should display all the books you can checkout
        //get user input
        //validate if book exists
        //when run it should call library checkout
        //library inject checked in books collection
        //checked out books collection
        //when checked out move it from checked in to checkout
    }
}

