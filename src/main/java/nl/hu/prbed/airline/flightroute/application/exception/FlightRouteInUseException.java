package nl.hu.prbed.airline.flightroute.application.exception;

public class FlightRouteInUseException extends RuntimeException {
    public FlightRouteInUseException(Long id) {
        super("Flightroute already in use: " + id);
    }
}
