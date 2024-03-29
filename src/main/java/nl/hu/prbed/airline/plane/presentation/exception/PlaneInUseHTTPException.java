package nl.hu.prbed.airline.plane.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Plane can not be deleted while it has flights planned")
public class PlaneInUseHTTPException extends RuntimeException{
    public PlaneInUseHTTPException(String reason){
        super(reason);
    }
}
