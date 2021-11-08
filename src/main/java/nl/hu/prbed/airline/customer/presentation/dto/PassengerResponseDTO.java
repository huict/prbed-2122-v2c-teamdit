package nl.hu.prbed.airline.customer.presentation.dto;

import nl.hu.prbed.airline.customer.domain.Passenger;

import java.time.LocalDateTime;

public class PassengerResponseDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public LocalDateTime dateOfBirth;
    public Integer phoneNumber;
    public String emailAddress;
    public String nationality;

    public PassengerResponseDTO(){}

    public PassengerResponseDTO(Passenger passenger){
        this.id = passenger.getId();
        this.firstName = passenger.getFirstName();
        this.lastName = passenger.getLastName();
        this.dateOfBirth = passenger.getDateOfBirth();
        this.phoneNumber = passenger.getPhoneNumber();
        this.emailAddress = passenger.getEmailAddress();
        this.nationality = passenger.getNationality();
    }
}
