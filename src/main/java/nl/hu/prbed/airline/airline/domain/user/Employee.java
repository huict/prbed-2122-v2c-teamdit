package nl.hu.prbed.airline.airline.domain.user;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;


@Component
@Entity
public class Employee {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;

    public Employee() {
    }

    public Employee(String firstName, String lastName, LocalDateTime dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

}
