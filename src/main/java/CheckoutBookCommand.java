public class CheckoutBookCommand implements Command {

    private Library library;

    public CheckoutBookCommand(Library library) {

        this.library = library;
    }

    @Override
    public void run() {
        library.checkout();
    }

    @Override
    public String name() {
        return "Checkout Books";
    }
}
