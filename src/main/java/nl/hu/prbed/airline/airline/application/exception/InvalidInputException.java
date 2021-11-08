package nl.hu.prbed.airline.airline.application.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String reason) {
        super(reason);
    }
}


