package nl.hu.prbed.airline.airport.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="Airport in use")
public class AirportInUseHTTPException extends RuntimeException {
    public AirportInUseHTTPException(String code) {
        super("Airport in use by a flightRoute, airport code: " + code);
    }
}
