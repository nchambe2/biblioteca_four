import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {
    @Test
    public void shouldDisplayTitleAuthorYear() {
        PrintStream printStream = mock(PrintStream.class);
        String title = "Title";
        String author = "Author";
        String yearPublished = "Year Published";
        Book book = new Book(printStream, title, author, yearPublished);

        book.details();

        verify(printStream).println(contains("Title | Author | Year Published"));

    }
}