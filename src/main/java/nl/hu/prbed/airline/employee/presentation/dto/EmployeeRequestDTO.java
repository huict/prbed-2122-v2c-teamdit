package nl.hu.prbed.airline.employee.presentation.dto;


import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class EmployeeRequestDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public LocalDateTime dateOfBirth;
}
