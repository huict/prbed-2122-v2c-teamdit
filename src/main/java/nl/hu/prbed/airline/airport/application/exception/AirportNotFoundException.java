package nl.hu.prbed.airline.airport.application.exception;

public class AirportNotFoundException extends RuntimeException {
    public final String code;
    public AirportNotFoundException(String code) {
        super("No airport with code: " + code);
        this.code = code;
    }
}
