public class CheckoutBookCommand implements Command {

    private Library library;
    private CheckoutBookValidator checkoutBookValidator;

    public CheckoutBookCommand(Library library, CheckoutBookValidator checkoutBookValidator) {

        this.library = library;
        this.checkoutBookValidator = checkoutBookValidator;
    }

    @Override
    public void run() {
        library.checkout(1);
        checkoutBookValidator.validate();
    }

    @Override
    public String name() {
        return "Checkout Books";
    }
}
