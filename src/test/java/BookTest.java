import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {
    @Test
    public void shouldDisplayTitleAuthorYear() {
        String title = "Title";
        String author = "Author";
        String yearPublished = "Year Published";
        Book book = new Book(title, author, yearPublished);

        assertThat(book.details(), is("Title | Author | Year Published"));

    }
}