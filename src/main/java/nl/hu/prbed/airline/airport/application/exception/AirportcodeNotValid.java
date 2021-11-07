package nl.hu.prbed.airline.airport.application.exception;

public class AirportcodeNotValid extends RuntimeException{
    public AirportcodeNotValid(String code) {
        super("This is not a valid ICAO code: " + code);
    }
}
