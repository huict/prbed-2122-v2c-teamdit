package nl.hu.prbed.airline.booking.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="Booking in use")
public class BookingInUseHTTPException extends RuntimeException{
    public BookingInUseHTTPException(){
        super();
    }
}
