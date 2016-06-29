public class CheckoutBookCommand implements Command {

    private LibraryValidator checkoutBookValidator;

    public CheckoutBookCommand(LibraryValidator checkoutBookValidator) {

        this.checkoutBookValidator = checkoutBookValidator;
    }

    @Override
    public void run() {
        checkoutBookValidator.validateIfBookIsCheckedIn();
    }

    @Override
    public String name() {
        return "Checkout Books";
    }
}
