package nl.hu.prbed.airline.flight.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Flight does not exist")
public class FlightNotFoundHTTPException extends RuntimeException{
    public FlightNotFoundHTTPException(){
        super("Could not find flight");
    }
}


