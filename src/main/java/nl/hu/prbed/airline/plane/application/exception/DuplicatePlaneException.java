package nl.hu.prbed.airline.plane.application.exception;

public class DuplicatePlaneException extends RuntimeException {
    public DuplicatePlaneException(String message) {
        super(message);
    }
}
