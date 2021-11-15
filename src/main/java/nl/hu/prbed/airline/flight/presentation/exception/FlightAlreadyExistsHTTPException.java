package nl.hu.prbed.airline.flight.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate flight")
public class FlightAlreadyExistsHTTPException extends RuntimeException {
    public FlightAlreadyExistsHTTPException(){
        super("Flight already exists");

    }
}
