package nl.hu.prbed.airline.airport.application.exception;

public class AirportCodeNotValidException extends RuntimeException{
    public AirportCodeNotValidException(String code) {
        super("This is not a valid ICAO code: " + code);
    }
}
