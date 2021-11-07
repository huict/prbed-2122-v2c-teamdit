package nl.hu.prbed.airline.plane.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PlaneNotFoundException extends RuntimeException {
    public PlaneNotFoundException(Long id) {
        super("No plane with id: " + id);
    }
}
