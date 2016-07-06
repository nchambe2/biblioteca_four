import java.io.PrintStream;
import java.util.List;

public class ReturnBookCommand implements Command {
    private LibraryValidator libraryValidator;
    private final PrintStream printStream;
    private List<Book> checkedOutBooks;
    private List<Book> checkedInBooks;

    public ReturnBookCommand(LibraryValidator libraryValidator, PrintStream printStream, List<Book> checkedOutBooks, List<Book> checkedInBooks) {

        this.libraryValidator = libraryValidator;
        this.printStream = printStream;
        this.checkedOutBooks = checkedOutBooks;
        this.checkedInBooks = checkedInBooks;
    }

    @Override
    public void run() {
        printStream.println("Enter the number that corresponds to the book you want to return:");
        libraryValidator.validate(checkedOutBooks, checkedInBooks, "Thank you for returning the book.", "This book can not be returned");
    }

    @Override
    public String name() {
        return "Return Book";
    }

    //to do includes
    //1.) Listing the books when  menu selection occurs
    //2.) Move books back and forth between data structures - done
    //3.) Implement multiple interfaces
    //4.) Make sure you have the correct tests for everything
}
