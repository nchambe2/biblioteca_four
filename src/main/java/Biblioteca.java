import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        List<Book> bookTitles = new ArrayList<>();
        Book parableOfTheSower = new Book(printStream, "Parable of the Sower", "Octavia Butler", "1993");
        Book harryPotter = new Book(printStream, "Harry Potter and the Chamber of Secrets", "JK Rowling", "1999");
        bookTitles.add(parableOfTheSower);
        bookTitles.add(harryPotter);
        Library library = new Library(bookTitles);
        Menu menu = new Menu(printStream, library);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Application application = new Application(printStream, menu, bufferedReader);
        
        application.start();
    }
}

//now we need a menu class done
//should be injected into application done
//Print the menu option done
//who should get the input from the user????
//menu could but is that the menu's job??
//Is that the library's job
//Is that the application's job = applications
//get input from the user done
//and then check to see if the input corresponds to the menu option