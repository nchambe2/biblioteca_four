import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
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
    private List<Book> checkedInBooks;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    @Before
    public void setUp(){
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);
        checkedInBooks = new ArrayList<>();
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        library = new Library(checkedInBooks, bufferedReader, printStream);
    }

    @Test
    public void shouldInvokeDetailsMethodOnceWhenThereIsOneBookInTheLibrary(){
        checkedInBooks.add(bookOne);

        library.listCheckedInBooks();

        verify(bookOne, times(1)).details();
    }

    @Test
    public void shouldDisplayBookTitleWhenThereIsOneBookInTheLibrary(){
        checkedInBooks.add(bookOne);

        library.listCheckedInBooks();

        verify(printStream).println(contains("1."));
    }

    @Test
    public void shouldInvokeDetailsMethodTwiceWhenThereAreMultipleBooksInTheLibrary(){
        checkedInBooks.add(bookOne);
        checkedInBooks.add(bookTwo);

        library.listCheckedInBooks();

        verify(bookOne).details();
        verify(bookTwo).details();
    }

    @Test
    public void shouldDisplayTwoBookTitlesWhenThereAreMultipleBooksInTheLibrary(){
        checkedInBooks.add(bookOne);
        checkedInBooks.add(bookTwo);

        library.listCheckedInBooks();

        verify(printStream).println(contains("2."));
    }

    @Test
    public void shouldCheckoutBook() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        checkedInBooks.add(bookOne);
        checkedInBooks.add(bookTwo);

        library.checkout();

        assertThat(checkedInBooks.size(), is(1));
    }
}