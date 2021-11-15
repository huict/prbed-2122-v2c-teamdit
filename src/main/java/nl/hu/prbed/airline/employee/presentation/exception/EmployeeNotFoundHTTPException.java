package nl.hu.prbed.airline.employee.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such employee")
public class EmployeeNotFoundHTTPException extends RuntimeException {
    public EmployeeNotFoundHTTPException(long id) {
        super("No employee with id: " + id);
    }
}
