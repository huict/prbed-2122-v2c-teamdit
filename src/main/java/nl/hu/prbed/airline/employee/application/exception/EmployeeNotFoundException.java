package nl.hu.prbed.airline.employee.application.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long id) {
        super("No employee with id: " + id);
    }
}
