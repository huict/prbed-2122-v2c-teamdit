package nl.hu.prbed.airline.airline.application.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such airport")
public class PlaneNotFoundException extends RuntimeException {
    public PlaneNotFoundException(Long id) {
        super("No plane with id: " + id);
    }
}
