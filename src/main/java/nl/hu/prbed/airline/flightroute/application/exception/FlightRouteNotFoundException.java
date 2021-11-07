package nl.hu.prbed.airline.flightroute.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FlightRouteNotFoundException extends RuntimeException {
    public FlightRouteNotFoundException() {
        super("No flightroute with that id");
    };
}
