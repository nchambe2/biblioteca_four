import java.util.List;

public class CheckoutBookValidator {
    private Library library;
    private List<Book> checkedInBooks;
    private Input input;

    public CheckoutBookValidator(Library library, List<Book> checkedInBooks, Input input) {

        this.library = library;
        this.checkedInBooks = checkedInBooks;
        this.input = input;
    }

    public void validate() {
        library.listCheckedInBooks();
        String bookToCheckout = input.getUserInput();

        int bookIndex = Integer.parseInt(bookToCheckout) - 1;

        if(bookIndex < checkedInBooks.size()) {
            library.checkout(bookIndex);
        }
    }
}
