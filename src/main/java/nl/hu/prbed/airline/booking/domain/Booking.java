package nl.hu.prbed.airline.booking.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.customer.domain.Customer;
import nl.hu.prbed.airline.customer.domain.Passenger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@Getter
@NoArgsConstructor
public class Booking{
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private BookingClass bookingClass;

    @ManyToMany
    private List<Flight> flights;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Passenger> passengers;


    public Booking(Customer customer, BookingClass bookingClass, List<Flight> flights, List<Passenger> passengers) {
        this.customer = customer;
        this.bookingClass = bookingClass;
        this.flights = flights;
        this.passengers = passengers;
    }

    public Booking(Long id, Customer customer, BookingClass bookingClass, List<Flight> flights, List<Passenger> passengers) {
        this(customer, bookingClass, flights, passengers);
        this.id = id;
    }

    public int getAmountOfPassengers() {
        return passengers.size() + 1;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    @Override
    public String toString() {
        StringBuilder passengerList = new StringBuilder();
        StringBuilder flightList = new StringBuilder();

        for (Passenger passenger : passengers) {
            passengerList.append("\n").append(passenger.toString());
        }

        for (Flight flight : flights) {
            flightList.append("\n").append(flight.toString());
        }

        return  "\n\ncustomer: " + customer.toString() +
                "\nbookingClass: " + bookingClass.toString().toLowerCase() +
                "\nflights: " + flightList+
                "\npassengers: " + passengerList;
    }
}
