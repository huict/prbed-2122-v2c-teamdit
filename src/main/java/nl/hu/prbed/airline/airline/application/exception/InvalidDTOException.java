package nl.hu.prbed.airline.airline.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class InvalidDTOException extends RuntimeException{
    public InvalidDTOException(String reason){
        super(reason);
    }
}
