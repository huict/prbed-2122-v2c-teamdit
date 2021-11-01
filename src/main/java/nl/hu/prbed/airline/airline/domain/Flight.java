package nl.hu.prbed.airline.airline.domain;


import nl.hu.prbed.airline.airline.domain.user.Customer;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Component
public class Flight {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    // TODO: Cleanup new list initialization on object creation
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    private LocalDateTime departureTime;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private FlightRoute route;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Plane plane;

    public Flight() {

    }

    public Flight(LocalDateTime departureTime, FlightRoute flightRoute, Plane plane) {
        this.departureTime = departureTime;
        this.route = flightRoute;
        this.plane = plane;
    }

    public void addBooking(Booking booking) {
        if (booking.getBookingClass().equals(BookingClass.BUSINESS) && bookings.size() < plane.getSeatsBusiness()) {
            bookings.add(booking);
        } else if (booking.getBookingClass().equals(BookingClass.ECONOMY) && bookings.size() < plane.getSeatsEconomy()) {
            bookings.add(booking);
        } else if (booking.getBookingClass().equals(BookingClass.FIRST) && bookings.size() < plane.getSeatsFirstClass()) {
            bookings.add(booking);
        }
    }

    public int flightOccupation() {
        return bookings.size();
    }

    public int seatsAvailable() {
        int totalSeats = plane.getSeatsFirstClass() + plane.getSeatsEconomy() + plane.getSeatsBusiness();
        return bookings.size() < totalSeats ? totalSeats - bookings.size() : 0;
    }


    public List<Booking> customersForBussinesClass() {
        return bookings.stream().filter(booking ->
                        booking.getBookingClass().equals(BookingClass.BUSINESS))
                .collect(Collectors.toList());
    }


    public List<Booking> customersForEconomyClass() {
        return bookings.stream().filter(booking ->
                        booking.getBookingClass().equals(BookingClass.BUSINESS))
                .collect(Collectors.toList());
    }


    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public FlightRoute getRoute() {
        return route;
    }

    public void setRoute(FlightRoute route) {
        this.route = route;
    }

    public Long getId() {
        return id;
    }
}
