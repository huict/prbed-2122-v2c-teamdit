package nl.hu.prbed.airline.booking.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such booking")
public class BookingNotFoundHTTPException extends RuntimeException {
    public BookingNotFoundHTTPException(long id) {
        super("No booking with id: " + id);
    }
}
