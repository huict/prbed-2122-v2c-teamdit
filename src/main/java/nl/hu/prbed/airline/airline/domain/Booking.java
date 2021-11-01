package nl.hu.prbed.airline.airline.domain;

import nl.hu.prbed.airline.airline.domain.user.Customer;
import nl.hu.prbed.airline.airline.domain.user.Passenger;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class Booking {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Customer customer;


    @Enumerated(EnumType.STRING)
    private BookingClass bookingClass;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Passenger> Passengers;

    public Booking() {
    }

    public Booking( Customer customer, BookingClass bookingClass, List<Passenger> Passengers) {
        this.customer = customer;
        this.bookingClass = bookingClass;
        this.Passengers = Passengers;
    }

    public Booking(Long id, Customer customer, BookingClass bookingClass, List<Passenger> passengers){
        this(customer, bookingClass, passengers);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public List<Passenger> getPassengers() {
        return Passengers;
    }
}
