package nl.hu.prbed.airline.plane.application.exception;

public class ReliantFlightsException extends RuntimeException{
    public ReliantFlightsException(String reason){
        super(reason);
    }
}
