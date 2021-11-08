package nl.hu.prbed.airline.customer.presentation.dto;

import java.time.LocalDateTime;

public class PassengerRequestDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public LocalDateTime dateOfBirth;
    public Integer phoneNumber;
    public String emailAddress;
    public String nationality;

    public PassengerRequestDTO() {
    }
}