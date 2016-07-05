import java.io.PrintStream;
import java.util.List;

public class ReturnBookCommand implements Command {
    private LibraryValidator libraryValidator;
    private final PrintStream printStream;
    private List<Book> checkedOutBooks;

    public ReturnBookCommand(LibraryValidator libraryValidator, PrintStream printStream, List<Book> checkedOutBooks) {

        this.libraryValidator = libraryValidator;
        this.printStream = printStream;
        this.checkedOutBooks = checkedOutBooks;
    }

    @Override
    public void run() {
        printStream.println("Enter the number that corresponds to the book you want to return:");
        //libraryValidator.validateIfBookIsCheckedOut();
        libraryValidator.validate(checkedOutBooks, "Thank you for returning the book.", "This book can not be returned");
    }

    @Override
    public String name() {
        return "Return Book";
    }
}
