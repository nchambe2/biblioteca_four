import java.util.List;

public class Library {
    private List<Book> bookTitles;

    public Library(List<Book> bookTitles) {

        this.bookTitles = bookTitles;
    }

    public void list() {
        for(Book book : bookTitles) {
            book.details();
        }
    }
}
