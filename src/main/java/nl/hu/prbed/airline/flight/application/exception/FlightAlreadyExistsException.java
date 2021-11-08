package nl.hu.prbed.airline.flight.application.exception;

public class FlightAlreadyExistsException extends RuntimeException {
    public FlightAlreadyExistsException(){
        super("Flight already exists");

    }
}
