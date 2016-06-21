public class ListBookCommand implements Command {
    private Library library;

    public ListBookCommand(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        library.list();
    }
}

