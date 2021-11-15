package nl.hu.prbed.airline.plane.application.exception;

public class PlaneNotFoundException extends RuntimeException {
    public PlaneNotFoundException(Long id) {
        super("No plane with id: " + id);
    }
}
