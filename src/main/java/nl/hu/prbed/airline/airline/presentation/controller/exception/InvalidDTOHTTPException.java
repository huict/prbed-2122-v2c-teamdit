package nl.hu.prbed.airline.airline.presentation.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid request body")
public class InvalidDTOHTTPException extends RuntimeException{
    public InvalidDTOHTTPException(String reason){
        super(reason);
    }
}
