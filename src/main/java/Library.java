import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> checkedInBooks;
    private PrintStream printStream;

    public Library(List<Book> checkedInBooks, PrintStream printStream) {
        this.checkedInBooks = checkedInBooks;
        this.printStream = printStream;
    }

    public void listCheckedInBooks() {
        for(Book book : checkedInBooks){
            printStream.println((checkedInBooks.indexOf(book) + 1) + ". " + book.details());
        }
    }
    public void checkout(int bookIndex) {
            checkedInBooks.remove(bookIndex);
    }

}
