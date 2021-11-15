package nl.hu.prbed.airline.plane.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such plane")
public class PlaneNotFoundHTTPException extends RuntimeException {
    public PlaneNotFoundHTTPException(Long id) {
        super("No plane with id: " + id);
    }
}
