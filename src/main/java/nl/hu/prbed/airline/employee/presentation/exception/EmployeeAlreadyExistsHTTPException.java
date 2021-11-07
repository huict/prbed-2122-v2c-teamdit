package nl.hu.prbed.airline.employee.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason="Duplicate employee code")
public class EmployeeAlreadyExistsHTTPException extends RuntimeException {
    public EmployeeAlreadyExistsHTTPException(Long code) {
        super("employee already exists with code: " + code);
    }
}
