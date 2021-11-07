package nl.hu.prbed.airline.airport.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(String code) {
        super("No airport with code: " + code);
    }
}
