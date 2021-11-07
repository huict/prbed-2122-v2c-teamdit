package nl.hu.prbed.airline.plane.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="No such plane")
public class DuplicatePlaneHTTPException extends RuntimeException {
    public DuplicatePlaneHTTPException(String message) {
        super(message);
    }
}
