package nl.hu.prbed.airline.employee.application.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(String username) {
        super("employee already exists with username: " + username);
    }
}
