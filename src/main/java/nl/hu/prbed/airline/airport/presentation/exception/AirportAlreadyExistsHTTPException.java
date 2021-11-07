package nl.hu.prbed.airline.airport.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="Duplicate airport code")
public class AirportAlreadyExistsHTTPException extends RuntimeException {
    public AirportAlreadyExistsHTTPException(String code) {
        super("Airport already exists with code: " + code);
    }
}
