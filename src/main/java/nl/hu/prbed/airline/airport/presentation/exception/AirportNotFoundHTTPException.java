package nl.hu.prbed.airline.airport.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such airport")
public class AirportNotFoundHTTPException extends RuntimeException {
    public AirportNotFoundHTTPException(String code) {
        super("No airport with code: " + code);
    }
}
