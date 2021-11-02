package nl.hu.prbed.airline.airline.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Plane can't be deleted while it has flights planned")
public class ReliantFlightsException extends RuntimeException{
    public ReliantFlightsException(String reason){
        super(reason);
    }
}
