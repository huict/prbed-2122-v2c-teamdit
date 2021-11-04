package nl.hu.prbed.airline.booking.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.customer.domain.Customer;
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

    @ManyToOne
    private Flight flight;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Passenger> passengers;


    public Booking(Customer customer, BookingClass bookingClass, Flight flight, List<Passenger> passengers) {
        this.customer = customer;
        this.bookingClass = bookingClass;
        this.flight = flight;
        this.passengers = passengers;
    }

    public Booking(Long id, Customer customer, BookingClass bookingClass, Flight flight, List<Passenger> passengers) {
            this(customer, bookingClass, flight, passengers);
            this.id = id;
        }

    public int getAmountOfPassengers() {
        return passengers.size() + 1;
    }
}
