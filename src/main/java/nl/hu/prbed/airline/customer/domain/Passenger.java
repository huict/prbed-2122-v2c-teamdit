package nl.hu.prbed.airline.customer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Component
@Entity
@NoArgsConstructor
@Getter
public class Passenger {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Long phoneNumber;
    private String emailAddress;
    private String nationality;

    public Passenger(String firstName, String lastName, Date dateOfBirth, Long phoneNumber, String emailAddress, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "\nfirstName: " + firstName  +
                "\nlastName: " + lastName +
                "\ndateOfBirth: " + dateOfBirth +
                "\nphoneNumber: " + phoneNumber +
                "\nemailAddress: " + emailAddress +
                "\nnationality: " + nationality;
    }
}
