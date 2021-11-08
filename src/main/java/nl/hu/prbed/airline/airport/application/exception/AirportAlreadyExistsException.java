package nl.hu.prbed.airline.airport.application.exception;

public class AirportAlreadyExistsException extends RuntimeException {
    public AirportAlreadyExistsException(String code) {
        super("Airport already exists with code: " + code);
    }
}
