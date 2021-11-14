package nl.hu.prbed.airline.flight.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="Flight is in use")
public class FlightInUseHTTPException extends RuntimeException{
    public FlightInUseHTTPException (){
        super();
    }
}
