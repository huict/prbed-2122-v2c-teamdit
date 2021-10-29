package nl.hu.prbed.airline.airline.domain.user;
import nl.hu.prbed.airline.airline.domain.Booking;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Component
@Entity
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer phoneNumber;
    private String emailAdress;
    private String nationality;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Booking> bookings;

    public Customer() {

    }

    public Customer(String firstName, String lastName, Date dateOfBirth, Integer phoneNumber, String emailAdress, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
        this.nationality = nationality;
    }

}
