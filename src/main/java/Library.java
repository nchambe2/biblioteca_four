import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> checkedInBooks;
    private List<Book> checkedOutBooks;
    private PrintStream printStream;

    public Library(List<Book> checkedInBooks, List<Book> checkedOutBooks, PrintStream printStream) {
        this.checkedInBooks = checkedInBooks;
        this.checkedOutBooks = checkedOutBooks;
        this.printStream = printStream;
    }

    public void listCheckedInBooks() {
        for(Book book : checkedInBooks){
            printStream.println((checkedInBooks.indexOf(book) + 1) + ". " + book.details());
        }
    }
    public void checkout(int bookIndex) {
        checkedInBooks.remove(bookIndex);
        printStream.println("Thank you! Enjoy the book");
    }

    public void returnBook(int bookIndex) {
        checkedOutBooks.remove(bookIndex);
        printStream.println("Thank you for returning the book.");
    }

    public void removeBookFrom(List<Book> bookCatalog, int bookIndex) {
        bookCatalog.remove(bookIndex);
    }
}
