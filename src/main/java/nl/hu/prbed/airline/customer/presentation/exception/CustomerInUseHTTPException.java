package nl.hu.prbed.airline.customer.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Customer is in use")
public class CustomerInUseHTTPException extends RuntimeException{
    public CustomerInUseHTTPException(){
        super();
    }
}
