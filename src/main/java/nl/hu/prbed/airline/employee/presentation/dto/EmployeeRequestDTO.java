package nl.hu.prbed.airline.employee.presentation.dto;

import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@NoArgsConstructor
public class EmployeeRequestDTO {
    public Long id;
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
}
