import java.io.PrintStream;

public class Menu {
    private PrintStream printStream;
    private Library library;

    public Menu(PrintStream printStream, Library library) {

        this.printStream = printStream;
        this.library = library;
    }

    public void display() {
        printStream.println("Menu Options: " + "\nList Books");
    }

    public void execute(String userSelection) {

        if(userSelection.equals("1")) {
            library.list();
        }
    }

    //if the userSelection is one then execute library .list
}
