package nl.hu.prbed.airline.customer.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Emailaddress already in use")
public class CustomerEmailAddressAlreadyInUseHTTPException extends RuntimeException {
    public CustomerEmailAddressAlreadyInUseHTTPException(String email) {
        super("Emailaddress "+ email+" is already in use");
    }
}



