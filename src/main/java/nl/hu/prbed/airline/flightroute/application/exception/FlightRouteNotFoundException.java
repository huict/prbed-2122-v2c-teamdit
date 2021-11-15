package nl.hu.prbed.airline.flightroute.application.exception;

public class FlightRouteNotFoundException extends RuntimeException {
    public FlightRouteNotFoundException() {
        super("No flightroute with that id");
    }
}
