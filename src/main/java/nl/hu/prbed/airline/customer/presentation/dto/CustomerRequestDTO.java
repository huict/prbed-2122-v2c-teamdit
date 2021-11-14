package nl.hu.prbed.airline.customer.presentation.dto;

import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@NoArgsConstructor
public class CustomerRequestDTO {
    public Long id;
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public Long phoneNumber;
    public String emailAddress;
    public String nationality;
}
