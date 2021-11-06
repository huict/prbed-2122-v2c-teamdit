package nl.hu.prbed.airline.employee.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such employee")
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long id) {
        super("No employee with id: " + id);
    }
}
