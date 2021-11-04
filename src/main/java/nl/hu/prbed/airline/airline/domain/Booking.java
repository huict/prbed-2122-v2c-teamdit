package nl.hu.prbed.airline.airline.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.airline.domain.user.Customer;
import nl.hu.prbed.airline.airline.domain.user.Passenger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@Getter
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private BookingClass bookingClass;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Passenger> Passengers;

    @ManyToOne
    private Flight flight;

    public Booking( Customer customer, BookingClass bookingClass, List<Passenger> Passengers, Flight flight) {
        this.customer = customer;
        this.bookingClass = bookingClass;
        this.Passengers = Passengers;
        this.flight = flight;
    }

    public Booking(Long id, Customer customer, BookingClass bookingClass, List<Passenger> passengers, Flight flight){
        this(customer, bookingClass, passengers, flight);
        this.id = id;
    }
}
