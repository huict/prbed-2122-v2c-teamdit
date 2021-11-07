package nl.hu.prbed.airline.booking.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(long id) {
        super("No booking with id: " + id);
    }
}
