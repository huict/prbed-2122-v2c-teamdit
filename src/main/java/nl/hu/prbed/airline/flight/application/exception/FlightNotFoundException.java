package nl.hu.prbed.airline.flight.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Flight doesn't exist")
public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(){
        super("Couldn't find flight!");
    }
}


