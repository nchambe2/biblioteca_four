import java.io.PrintStream;
import java.util.List;

public class CheckoutBookValidator {
    private Library library;
    private List<Book> checkedInBooks;
    private Input input;
    private PrintStream printStream;

    public CheckoutBookValidator(Library library, List<Book> checkedInBooks, Input input, PrintStream printStream) {

        this.library = library;
        this.checkedInBooks = checkedInBooks;
        this.input = input;
        this.printStream = printStream;
    }

    public void validate() {
        library.listCheckedInBooks();
        String bookToCheckout = input.getUserInput();

        int bookIndex = Integer.parseInt(bookToCheckout) - 1;

        if(bookIndex < checkedInBooks.size()) {
            library.checkout(bookIndex);
        } else {
            printStream.println("That book is not available.");
        }
    }
}
