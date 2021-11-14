package nl.hu.prbed.airline.airline.application.exception;

public class NoAirlineExistsException extends RuntimeException {
    public NoAirlineExistsException(){
        super("Could not find an airline");
    }
}
