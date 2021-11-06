package nl.hu.prbed.airline.booking.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "There are no seats available for the given class")
public class NoSeatsLeftForClassException extends RuntimeException{
    public NoSeatsLeftForClassException() {
        super("Seats for given class are unavailable");
    }

}
