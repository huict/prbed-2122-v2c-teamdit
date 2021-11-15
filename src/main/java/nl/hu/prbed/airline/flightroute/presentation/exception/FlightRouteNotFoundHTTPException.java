package nl.hu.prbed.airline.flightroute.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such flightroute")
public class FlightRouteNotFoundHTTPException extends RuntimeException {
    public FlightRouteNotFoundHTTPException() {
        super("No flightroute with that id");
    }
}
