package nl.hu.prbed.airline.customer.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such customer")
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(long id) {
        super("No customer with id: " + id);
    }
}
