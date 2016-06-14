import java.io.PrintStream;

public class Biblioteca {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Application application = new Application(printStream);
        application.start();
    }
}
