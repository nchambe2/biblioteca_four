import java.io.PrintStream;
import java.util.List;

public class LibraryValidator {
    private Library library;
    private Input input;
    private PrintStream printStream;

    public LibraryValidator(Library library, Input input, PrintStream printStream) {

        this.library = library;
        this.input = input;
        this.printStream = printStream;
    }

    public void validate(List<Book> bookCatalogToRemoveFrom, List<Book> bookCatalogToAddTo, String successMessage, String unsuccessfulMessage) {
        String bookToCheckIn = input.getUserInput();

        int bookIndex = Integer.parseInt(bookToCheckIn) - 1;

        if(bookIndex < bookCatalogToRemoveFrom.size()) {
            library.removeBookFrom(bookCatalogToRemoveFrom, bookCatalogToAddTo, bookIndex, successMessage);
        } else {
            printStream.println(unsuccessfulMessage);
        }
    }

}
