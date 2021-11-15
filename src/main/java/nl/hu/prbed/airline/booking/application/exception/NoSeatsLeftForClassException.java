package nl.hu.prbed.airline.booking.application.exception;

public class NoSeatsLeftForClassException extends RuntimeException{
    public NoSeatsLeftForClassException() {
        super("Seats for given class are unavailable");
    }

}
