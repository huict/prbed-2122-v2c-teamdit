package nl.hu.prbed.airline.airline.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String reason) {
        super(reason);
    }
}


