package nl.hu.prbed.airline.employee.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="Duplicate employee code")
public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(Long code) {
        super("employee already exists with code: " + code);
    }
}
