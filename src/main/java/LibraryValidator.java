import java.io.PrintStream;
import java.util.List;

public class LibraryValidator {
    private Library library;
    private List<Book> checkedInBooks;
    private List<Book> checkedOutBooks;
    private Input input;
    private PrintStream printStream;

    public LibraryValidator(Library library, List<Book> checkedInBooks, List<Book> checkedOutBooks, Input input, PrintStream printStream) {

        this.library = library;
        this.checkedInBooks = checkedInBooks;
        this.checkedOutBooks = checkedOutBooks;
        this.input = input;
        this.printStream = printStream;
    }

    public void validateIfBookIsCheckedIn() {
        //should just be validating
        //should not be prompting
        //getting input
        //and validating
        printStream.println("Enter the number that corresponds to the book you want to checkout:");
        String bookToCheckout = input.getUserInput();

        int bookIndex = Integer.parseInt(bookToCheckout) - 1;

        if(bookIndex < checkedInBooks.size()) {
            library.removeBookFrom(checkedInBooks, bookIndex);
        } else {
            printStream.println("That book is not available.");
        }
    }

    public void validateIfBookIsCheckedOut() {
        printStream.println("Enter the number that corresponds to the book you want to check in:");
        String bookToCheckIn= input.getUserInput();

        int bookIndex = Integer.parseInt(bookToCheckIn) - 1;

        if(bookIndex < checkedOutBooks.size()) {
            library.removeBookFrom(checkedOutBooks, bookIndex);
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }
}
