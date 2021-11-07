package nl.hu.prbed.airline.booking.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "There are no seats available for the given class")
public class NoSeatsLeftForClassHTTPException extends RuntimeException{
    public NoSeatsLeftForClassHTTPException() {
        super("Seats for given class are unavailable");
    }

}
