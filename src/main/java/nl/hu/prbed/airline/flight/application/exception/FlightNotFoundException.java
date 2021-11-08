package nl.hu.prbed.airline.flight.application.exception;

public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(){
        super("Could not find flight");
    }
}


