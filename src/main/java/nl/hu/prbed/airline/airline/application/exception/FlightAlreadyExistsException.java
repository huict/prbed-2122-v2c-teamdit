package nl.hu.prbed.airline.airline.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate flight")
public class FlightAlreadyExistsException extends RuntimeException {
    public FlightAlreadyExistsException(Long id){
        super("Flight already exists with id: "+id);

    }
}


//
//@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate flightroute")
//public class FlightRouteAlreadyExistsException extends RuntimeException {
//    public FlightRouteAlreadyExistsException(Long id) {
//        super("Flightroute already exists with id: " + id);
//    }
//}
