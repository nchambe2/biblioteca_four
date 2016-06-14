import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private List<String> booksInTheLibrary;
    private Book book;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        booksInTheLibrary = new ArrayList<>();
        application = new Application(printStream, booksInTheLibrary);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStarts() {
        application.start();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldListBookTitleWhenThereIsOneBookInTheLibrary() {
        String bookTitle = "Title 1";

        booksInTheLibrary.add(bookTitle);

        application.start();

        verify(printStream).println(contains("Title 1"));
    }

    @Test
    public void shouldListBookTitlesWhenThereAreMultipleBooksInTheLibrary() {
        String bookTitleOne = "Title 1";
        String bookTitleTwo = "Title 2";

        booksInTheLibrary.add(bookTitleOne);
        booksInTheLibrary.add(bookTitleTwo);

        application.start();

        verify(printStream).println(contains(bookTitleOne));
        verify(printStream).println(contains(bookTitleTwo));
    }

//    @Test
//    public void shouldDisplayBookDetails() {
//        application.start();
//
//        verify(book).details();
//    }
   //now we want the strings to be books
    //need a book class
    //book will have a title, author, year



}
