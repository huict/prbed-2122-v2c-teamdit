package nl.hu.prbed.airline.customer.presentation.dto;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class CustomerRequestDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public LocalDateTime dateOfBirth;
    public Long phoneNumber;
    public String emailAddress;
    public String nationality;
}
