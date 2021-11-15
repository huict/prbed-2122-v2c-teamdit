package nl.hu.prbed.airline.airline.presentation.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No airline found")
public class NoAirlineExistsHTTPException extends RuntimeException {
    public NoAirlineExistsHTTPException(){
        super("Could not find an airline");
    }
}
