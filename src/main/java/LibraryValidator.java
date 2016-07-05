import java.io.PrintStream;
import java.util.List;

public class LibraryValidator {
    private Library library;
    private List<Book> checkedOutBooks;
    private Input input;
    private PrintStream printStream;

    public LibraryValidator(Library library, List<Book> checkedOutBooks, Input input, PrintStream printStream) {

        this.library = library;
        this.checkedOutBooks = checkedOutBooks;
        this.input = input;
        this.printStream = printStream;
    }

    public void validateIfBookIsCheckedOut() {
        printStream.println("Enter the number that corresponds to the book you want to return:");
        String bookToCheckIn = input.getUserInput();

        int bookIndex = Integer.parseInt(bookToCheckIn) - 1;

        if(bookIndex < checkedOutBooks.size()) {
            library.removeBookFrom(checkedOutBooks, bookIndex, successfulReturnMessage());
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    public void validate(List<Book> bookCatalog, String successMessage, String unsuccessfulMessage) {
        String bookToCheckIn = input.getUserInput();

        int bookIndex = Integer.parseInt(bookToCheckIn) - 1;

        if(bookIndex < bookCatalog.size()) {
            library.removeBookFrom(bookCatalog, bookIndex, successMessage);
        } else {
            printStream.println(unsuccessfulMessage);
        }
    }


    private String successfulReturnMessage() {
        return "Thank you for returning the book.";
    }

}
