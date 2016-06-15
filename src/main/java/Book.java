import java.io.PrintStream;

public class Book {

    private PrintStream printStream;
    private String title;
    private String author;
    private String yearPublished;

    public Book(PrintStream printStream, String title, String author, String yearPublished) {

        this.printStream = printStream;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void details() {
        printStream.println(String.join(" | ", title, author, yearPublished));
    }
}
