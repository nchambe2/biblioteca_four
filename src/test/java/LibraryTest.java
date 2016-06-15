import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LibraryTest {

    private Library library;
    private List<Book> bookTitles;
    private Book book;

    @Before
    public void setUp(){
        book = mock(Book.class);
        bookTitles = new ArrayList<>();
        library = new Library(bookTitles);
    }

    @Test
    public void shouldDisplayBookTitleWhenThereIsOneBookIntheLibrary(){
        bookTitles.add(book);

        library.list();

        verify(book, times(1)).details();
    }

    @Test
    public void shouldDisplayBookTitleWhenThereIsMultipleBooksInTheLibrary(){
        bookTitles.add(book);
        bookTitles.add(book);

        library.list();

        verify(book, times(2)).details();
    }
}