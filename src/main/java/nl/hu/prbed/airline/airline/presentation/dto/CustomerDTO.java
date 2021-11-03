package nl.hu.prbed.airline.airline.presentation.dto;

import nl.hu.prbed.airline.airline.domain.Booking;
import nl.hu.prbed.airline.airline.domain.BookingClass;
import nl.hu.prbed.airline.airline.domain.user.Customer;
import nl.hu.prbed.airline.airline.domain.user.Passenger;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public LocalDateTime dateOfBirth;
    public Integer phoneNumber;
    public String emailAddress;
    public String nationality;

    public CustomerDTO(){}

    public CustomerDTO(Customer customer){
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.dateOfBirth = customer.getDateOfBirth();
        this.phoneNumber = customer.getPhoneNumber();
        this.emailAddress = customer.getEmailAddress();
        this.nationality = customer.getNationality();
    }

}
