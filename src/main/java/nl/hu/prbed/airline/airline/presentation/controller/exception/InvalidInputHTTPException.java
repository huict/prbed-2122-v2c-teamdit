package nl.hu.prbed.airline.airline.presentation.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Input is empty")
public class InvalidInputHTTPException extends RuntimeException {
    public InvalidInputHTTPException(String reason) {
        super(reason);
    }
}


