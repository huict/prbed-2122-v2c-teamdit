package nl.hu.prbed.airline.flightroute.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate flightroute")
public class FlightRouteAlreadyExistsHTTPException extends RuntimeException {
    public FlightRouteAlreadyExistsHTTPException() {
        super("Flightroute already exists");
    }
}
