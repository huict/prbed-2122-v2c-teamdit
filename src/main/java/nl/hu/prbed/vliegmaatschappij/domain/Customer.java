package nl.hu.prbed.vliegmaatschappij.domain;

import java.util.Date;
import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer phoneNumber;
    private String emailAdress;
    private String nationality;
    private List<Booking> bookings;


    public Customer(String firstName, String lastName, Date dateOfBirth, Integer phoneNumber, String emailAdress, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
        this.nationality = nationality;
    }

}
