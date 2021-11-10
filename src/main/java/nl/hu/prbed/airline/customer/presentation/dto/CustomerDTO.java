package nl.hu.prbed.airline.customer.presentation.dto;

import nl.hu.prbed.airline.customer.domain.Customer;

import java.time.LocalDateTime;

public class CustomerDTO {
    public Long id;
    public String username;
    public String firstName;
    public String lastName;
    public LocalDateTime dateOfBirth;
    public Long phoneNumber;
    public String emailAddress;
    public String nationality;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.dateOfBirth = customer.getDateOfBirth();
        this.phoneNumber = customer.getPhoneNumber();
        this.emailAddress = customer.getEmailAddress();
        this.nationality = customer.getNationality();
    }

    public CustomerDTO(Long id,
                       String firstName,
                       String lastName,
                       LocalDateTime dateOfBirth,
                       Long phoneNumber,
                       String emailAddress,
                       String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
    }
}
