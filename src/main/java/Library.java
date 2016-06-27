import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> checkedInBooks;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Library(List<Book> checkedInBooks, BufferedReader bufferedReader, PrintStream printStream) {
        this.checkedInBooks = checkedInBooks;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void listCheckedInBooks() {
        for(Book book : checkedInBooks){
            printStream.println((checkedInBooks.indexOf(book) + 1) + ". " + book.details());
        }
    }
    public void checkout() {
        String bookToCheckout = getUserInput();
        int bookIndex = Integer.parseInt(bookToCheckout) - 1;

        if(bookIndex < checkedInBooks.size()) {
            checkedInBooks.remove(bookIndex);
        } else {
            printStream.println("Book is not available");
        }
    }

    private String getUserInput() {
        String optionSelected = "";
        try {
            optionSelected = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  optionSelected;
    }

}
