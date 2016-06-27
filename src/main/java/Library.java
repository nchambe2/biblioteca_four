import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> checkedInBooks;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Library(Map<String, Book> checkedInBooks, BufferedReader bufferedReader, PrintStream printStream) {
        this.checkedInBooks = checkedInBooks;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void listCheckedInBooks() {
        for(Map.Entry<String, Book> book : checkedInBooks.entrySet()){
            book.getValue().details();
        }
    }
    public void checkout() {
        String bookToCheckoutKey = getUserInput();

        if(checkedInBooks.containsKey(bookToCheckoutKey)) {
            checkedInBooks.remove(bookToCheckoutKey);
        } else {
            printStream.println("Book is not availbe");
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
