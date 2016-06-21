import java.io.PrintStream;

public class QuitCommand implements Command {
    private PrintStream printStream;

    public QuitCommand(PrintStream printStream) {

        this.printStream = printStream;
    }

    @Override
    public void run() {
        printStream.println("Goodbye !");
    }

    @Override
    public String name() {
        return "Quit";
    }
}
