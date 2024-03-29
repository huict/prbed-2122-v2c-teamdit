package nl.hu.prbed.airline.customer.presentation.dto;

import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.customer.domain.Passenger;

import java.sql.Date;

@NoArgsConstructor
public class PassengerDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public Long phoneNumber;
    public String emailAddress;
    public String nationality;

    public PassengerDTO(Passenger passenger){
        this.id = passenger.getId();
        this.firstName = passenger.getFirstName();
        this.lastName = passenger.getLastName();
        this.dateOfBirth = passenger.getDateOfBirth();
        this.phoneNumber = passenger.getPhoneNumber();
        this.emailAddress = passenger.getEmailAddress();
        this.nationality = passenger.getNationality();
    }
}
