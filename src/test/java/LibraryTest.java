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
    private Book bookThree;
    private List<Book> checkedInBooks;
    private PrintStream printStream;
    private List<Book> checkedOutBooks;


    @Before
    public void setUp(){
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);
        bookThree = mock(Book.class);
        checkedInBooks = new ArrayList<>();
        checkedOutBooks = new ArrayList<>();
        printStream = mock(PrintStream.class);
        library = new Library(checkedInBooks, checkedOutBooks, printStream);
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
    public void shouldRemoveBookFromCheckedInListWhenBookIsCheckedOut() throws IOException {
        checkedInBooks.add(bookOne);
        checkedInBooks.add(bookTwo);

        library.checkout(1);

        assertThat(checkedInBooks.size(), is(1));
    }

    @Test
    public void shouldDisplaySuccessfulCheckoutMessageWhenBookHasBeenRemovedFromCheckedInBookList() {
        checkedInBooks.add(bookOne);
        checkedInBooks.add(bookTwo);

        library.checkout(1);

        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldRemoveBookFromCheckedOutBookWhenBookIsReturned() {
        checkedOutBooks.add(bookThree);

        library.returnBook(0);

        assertThat(checkedOutBooks.size(), is(0));
    }

    @Test
    public void shouldDisplaySuccessfulReturnMessageWhenBookHasBeenReturned() {
        checkedOutBooks.add(bookThree);

        library.returnBook(0);

        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldRemoveBookFromCheckedInBooksList() {
        checkedInBooks.add(bookOne);

        library.removeBookFrom(checkedInBooks, 0);

        assertThat(checkedInBooks.size(), is(0));
    }

    @Test
    public void shouldRemoveBookFromCheckedOutBooksList() {
        checkedOutBooks.add(bookOne);

        library.removeBookFrom(checkedOutBooks, 0);

        assertThat(checkedOutBooks.size(), is(0));
    }

}