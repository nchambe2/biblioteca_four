public class CheckoutBookCommand implements Command {

    private CheckoutBookValidator checkoutBookValidator;

    public CheckoutBookCommand(CheckoutBookValidator checkoutBookValidator) {

        this.checkoutBookValidator = checkoutBookValidator;
    }

    @Override
    public void run() {
        checkoutBookValidator.validate();
    }

    @Override
    public String name() {
        return "Checkout Books";
    }
}
