package nl.hu.prbed.airline.plane.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ReliantFlightsException extends RuntimeException{
    public ReliantFlightsException(String reason){
        super(reason);
    }
}
