package nl.hu.prbed.airline.customer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.booking.domain.Booking;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Entity
@NoArgsConstructor
@Getter
public class Customer {
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

    @OneToMany
    private List<Booking> bookings;

    public Customer(String firstName, String lastName, LocalDateTime dateOfBirth, Integer phoneNumber, String emailAddress, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
    }

}
