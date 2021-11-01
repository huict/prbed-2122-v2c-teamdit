package nl.hu.prbed.airline.airline.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such flightroute")
public class FlightRouteNotFoundException extends RuntimeException {
    public FlightRouteNotFoundException() {
        super("No flightroute with that id");
    };
}
