import java.io.PrintStream;
import java.util.List;

public class CheckoutBookCommand implements Command {

    private LibraryValidator checkoutBookValidator;
    private final PrintStream printStream;
    private final List<Book> checkedInBooks;

    public CheckoutBookCommand(LibraryValidator checkoutBookValidator, PrintStream printStream, List<Book> checkedinBooks) {

        this.checkoutBookValidator = checkoutBookValidator;
        this.printStream = printStream;
        this.checkedInBooks = checkedinBooks;
    }

    @Override
    public void run() {
        printStream.println("Enter the number that corresponds to the book you want to checkout:");
       // checkoutBookValidator.validateIfBookIsCheckedIn();
        checkoutBookValidator.validate(checkedInBooks, "Thank you! Enjoy the book", "That book can't be checked in.");
    }

    @Override
    public String name() {
        return "Checkout Books";
    }
}
