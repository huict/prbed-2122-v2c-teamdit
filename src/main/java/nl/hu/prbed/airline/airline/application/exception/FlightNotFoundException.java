package nl.hu.prbed.airline.airline.application.exception;

import nl.hu.prbed.airline.airline.domain.FlightRoute;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Flight doesn't exist")
public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(FlightRoute route, LocalDateTime departure){
        super("Couldn't find flight with route: "+ route+ " departure: "+departure);
    }
}


