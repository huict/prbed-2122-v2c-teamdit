package nl.hu.prbed.airline.employee.presentation.dto;

import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.employee.domain.Employee;

import java.sql.Date;

@NoArgsConstructor
public class EmployeeResponseDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;

    public EmployeeResponseDTO(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.dateOfBirth = employee.getDateOfBirth();
    }
}
