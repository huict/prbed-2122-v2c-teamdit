package nl.hu.prbed.vliegmaatschappij.domain;

import java.util.Date;

public class Employee {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public Employee(String firstName, String lastName, Date dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
