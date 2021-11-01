package nl.hu.prbed.airline.airline.domain.user;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Component
@Entity
public class Passenger {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private Integer phoneNumber;
    private String emailAddress;
    private String nationality;

    public Passenger() {

    }

    public Passenger(String firstName, String lastName, LocalDateTime dateOfBirth, Integer phoneNumber, String emailAddress, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
    }
}
