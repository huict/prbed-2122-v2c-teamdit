package nl.hu.prbed.airline.customer.presentation.dto;

import nl.hu.prbed.airline.customer.domain.Customer;

import java.time.LocalDateTime;

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
