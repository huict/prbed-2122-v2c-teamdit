package nl.hu.prbed.airline.employee.application.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(Long code) {
        super("employee already exists with code: " + code);
    }
}
