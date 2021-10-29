package nl.hu.prbed.airline.airline.domain.user;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Component
@Entity
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

}
