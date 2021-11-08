package nl.hu.prbed.airline.airline.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NoAirlineExistsException extends RuntimeException {
    public NoAirlineExistsException(){
        super("Could not find an airline");
    }
}
