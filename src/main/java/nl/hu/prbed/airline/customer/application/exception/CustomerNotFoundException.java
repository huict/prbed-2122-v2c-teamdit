package nl.hu.prbed.airline.customer.application.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(long id) {
        super("No customer with id: " + id);
    }
}
