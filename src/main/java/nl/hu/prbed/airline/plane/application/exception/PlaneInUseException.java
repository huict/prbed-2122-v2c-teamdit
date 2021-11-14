package nl.hu.prbed.airline.plane.application.exception;

public class PlaneInUseException extends RuntimeException{
    public PlaneInUseException(String reason){
        super(reason);
    }
}
