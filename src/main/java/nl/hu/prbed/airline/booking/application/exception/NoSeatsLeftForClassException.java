package nl.hu.prbed.airline.booking.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NoSeatsLeftForClassException extends RuntimeException{
    public NoSeatsLeftForClassException() {
        super("Seats for given class are unavailable");
    }

}
