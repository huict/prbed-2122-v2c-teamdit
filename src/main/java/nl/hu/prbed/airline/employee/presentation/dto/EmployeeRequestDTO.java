package nl.hu.prbed.airline.employee.presentation.dto;

import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.employee.domain.Employee;

import java.time.LocalDateTime;

public class EmployeeRequestDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public LocalDateTime dateOfBirth;

    public EmployeeRequestDTO() {
    }
}
