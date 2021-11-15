package nl.hu.prbed.airline.customer.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such customer")
public class CustomerNotFoundHTTPException extends RuntimeException {
    public CustomerNotFoundHTTPException(long id) {
        super("No customer with id: " + id);
    }
}
