package nl.hu.prbed.airline.booking.application.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(long id) {
        super("No booking with id: " + id);
    }
}
