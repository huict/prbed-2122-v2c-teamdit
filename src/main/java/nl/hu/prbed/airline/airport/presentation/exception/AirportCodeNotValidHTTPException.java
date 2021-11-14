package nl.hu.prbed.airline.airport.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Invalid ICAO code")
public class AirportCodeNotValidHTTPException extends RuntimeException{
    public AirportCodeNotValidHTTPException(String code) {
        super("This is not a valid ICAO code: " + code);
    }
}