package nl.hu.prbed.airline.airline.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "input is empty!")
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String reason) {
        super((reason));
    }
}


