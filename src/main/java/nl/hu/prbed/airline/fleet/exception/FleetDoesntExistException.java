package nl.hu.prbed.airline.fleet.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Fleet doesn't exist")
public class FleetDoesntExistException extends RuntimeException {
    public FleetDoesntExistException(){
        super("Couldn't find fleet!");
    }
}
