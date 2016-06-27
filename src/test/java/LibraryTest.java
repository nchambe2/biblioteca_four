import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private Library library;
    private Book bookOne;
    private Book bookTwo;
    private Map<String, Book> checkedInBooks;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    @Before
    public void setUp(){
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);
        checkedInBooks = new HashMap<>();
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        library = new Library(checkedInBooks, bufferedReader, printStream);
    }

    @Test
    public void shouldDisplayBookTitleWhenThereIsOneBookIntheLibraryX(){
        checkedInBooks.put("1", bookOne);

        library.listCheckedInBooks();

        verify(bookOne, times(1)).details();
    }

    @Test
    public void shouldDisplayBookTitleWhenThereIsMultipleBooksInTheLibrary(){
        checkedInBooks.put("1", bookOne);
        checkedInBooks.put("1", bookTwo);

        library.listCheckedInBooks();

        verify(bookOne).details();
        verify(bookTwo).details();
    }

    @Test
    public void shouldCheckoutBook() {
        checkedInBooks.put("1", bookOne);
        checkedInBooks.put("1", bookTwo);

        library.checkout();

        assertThat(checkedInBooks.size(), is(1));
    }
}