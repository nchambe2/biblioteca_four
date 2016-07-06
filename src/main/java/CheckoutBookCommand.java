import java.io.PrintStream;
import java.util.List;

public class CheckoutBookCommand implements Command {

    private LibraryValidator checkoutBookValidator;
    private final PrintStream printStream;
    private final List<Book> checkedInBooks;
    private final List<Book> checkedOutBooks;

    public CheckoutBookCommand(LibraryValidator checkoutBookValidator, PrintStream printStream, List<Book> checkedinBooks, List<Book> checkedOutBooks) {

        this.checkoutBookValidator = checkoutBookValidator;
        this.printStream = printStream;
        this.checkedInBooks = checkedinBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    @Override
    public void run() {
        printStream.println("Enter the number that corresponds to the book you want to checkout:");
        checkoutBookValidator.validate(checkedOutBooks, checkedInBooks, "Thank you! Enjoy the book", "That book can't be checked in.");
    }

    @Override
    public String name() {
        return "Checkout Books";
    }
}
