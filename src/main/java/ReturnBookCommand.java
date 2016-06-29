public class ReturnBookCommand implements Command {
    private LibraryValidator libraryValidator;

    public ReturnBookCommand(LibraryValidator libraryValidator) {

        this.libraryValidator = libraryValidator;
    }

    @Override
    public void run() {
        libraryValidator.validateIfBookIsCheckedOut();
    }

    @Override
    public String name() {
        return null;
    }
}
