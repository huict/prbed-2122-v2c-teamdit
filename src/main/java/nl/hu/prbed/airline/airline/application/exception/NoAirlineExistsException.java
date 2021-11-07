package nl.hu.prbed.airline.airline.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No airline found")
public class NoAirlineExistsException extends RuntimeException {
    public NoAirlineExistsException(){
        super("Could not find an airline");
    }
}
