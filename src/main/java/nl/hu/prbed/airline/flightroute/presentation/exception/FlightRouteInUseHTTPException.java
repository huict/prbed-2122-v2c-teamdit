package nl.hu.prbed.airline.flightroute.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="FlightRoute in use")
public class FlightRouteInUseHTTPException extends RuntimeException {
    public FlightRouteInUseHTTPException(Long id) {
        super("Flightroute already in use: " + id);
    }
}
