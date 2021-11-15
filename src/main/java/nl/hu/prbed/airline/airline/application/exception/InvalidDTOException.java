package nl.hu.prbed.airline.airline.application.exception;

public class InvalidDTOException extends RuntimeException{
    public InvalidDTOException(String reason){
        super(reason);
    }
}
