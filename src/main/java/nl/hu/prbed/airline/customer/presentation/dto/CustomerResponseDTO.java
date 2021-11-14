package nl.hu.prbed.airline.customer.presentation.dto;

import nl.hu.prbed.airline.customer.domain.Customer;

import java.sql.Date;

public class CustomerResponseDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public Long phoneNumber;
    public String emailAddress;
    public String nationality;


    public CustomerResponseDTO(){}

    public CustomerResponseDTO(Customer customer){
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.dateOfBirth = customer.getDateOfBirth();
        this.phoneNumber = customer.getPhoneNumber();
        this.emailAddress = customer.getEmailAddress();
        this.nationality = customer.getNationality();
    }

}
