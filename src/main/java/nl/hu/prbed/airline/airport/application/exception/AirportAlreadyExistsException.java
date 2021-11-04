package nl.hu.prbed.airline.airport.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="Duplicate airport code")
public class AirportAlreadyExistsException extends RuntimeException {
    public AirportAlreadyExistsException(String code) {
        super("Airport already exists with code: " + code);
    }
}
