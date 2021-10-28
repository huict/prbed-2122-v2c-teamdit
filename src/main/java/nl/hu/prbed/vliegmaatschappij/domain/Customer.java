package nl.hu.prbed.vliegmaatschappij.domain;

import java.util.Date;

public class Customer {

    public Customer(String firstName, String lastName, Date dateOfBirth, Integer phoneNumber, String emailAdress, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
        this.nationality = nationality;
    }

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer phoneNumber;
    private String emailAdress;
    private String nationality;

}
