package nl.hu.prbed.airline.airport.application.exception;

public class AirportcodeNotValidException extends RuntimeException{
    public AirportcodeNotValidException(String code) {
        super("This is not a valid ICAO code: " + code);
    }
}
