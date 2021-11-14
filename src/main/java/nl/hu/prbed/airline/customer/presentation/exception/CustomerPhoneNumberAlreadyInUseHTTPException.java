package nl.hu.prbed.airline.customer.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Phonenumber already in use")
public class CustomerPhoneNumberAlreadyInUseHTTPException extends RuntimeException {
    public CustomerPhoneNumberAlreadyInUseHTTPException(Long phone) {
        super("Phonenumber "+phone + " is already in use");
    }
}

