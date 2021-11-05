package nl.hu.prbed.airline.airline.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Airline can only have one fleet!")
public class MoreThanOneFleetException extends RuntimeException{
    public MoreThanOneFleetException(String reason){
        super((reason));
    }
}
