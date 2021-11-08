package nl.hu.prbed.airline.plane.application.exception;


public class InvalidDTOException extends RuntimeException{
    public InvalidDTOException(String reason){
        super(reason);
    }
}
