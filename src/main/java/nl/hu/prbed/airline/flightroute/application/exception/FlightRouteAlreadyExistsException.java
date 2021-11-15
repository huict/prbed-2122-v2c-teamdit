package nl.hu.prbed.airline.flightroute.application.exception;

public class FlightRouteAlreadyExistsException extends RuntimeException {
    public FlightRouteAlreadyExistsException() {
        super("Flightroute already exists");
    }
}
