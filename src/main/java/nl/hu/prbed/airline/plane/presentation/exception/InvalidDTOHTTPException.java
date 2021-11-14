package nl.hu.prbed.airline.plane.presentation.exception;


public class InvalidDTOHTTPException extends RuntimeException{
    public InvalidDTOHTTPException(String reason){
        super(reason);
    }
}
