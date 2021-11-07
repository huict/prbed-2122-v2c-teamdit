package nl.hu.prbed.airline.flight.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(){
        super("Could not find flight");
    }
}


