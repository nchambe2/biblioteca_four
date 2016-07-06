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

    public void removeBookFrom(List<Book> bookCatalogToRemoveFrom, List<Book> bookCatalogToAddTo, int bookIndex, String successMessage) {
        Book bookToAdd = bookCatalogToRemoveFrom.remove(bookIndex);
        bookCatalogToAddTo.add(bookToAdd);
        printStream.println(successMessage);
    }

    //what is the act of returning a book
    //you remove the book from the checked out booklist
    //you add the book to the checked in booklist

    //what is the act of checking out a book
    //you remove the book from the checked in booklist
    //you add the book to the checked out booklist
}
