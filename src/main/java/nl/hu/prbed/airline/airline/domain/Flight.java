package nl.hu.prbed.airline.airline.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import nl.hu.prbed.airline.airline.domain.user.Customer;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
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
    private List<Booking> bookings = new ArrayList<>();

    private Date departureTime;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private FlightRoute route;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Plane plane;

    public Flight() {

    }

    public Flight(Date departureTime, FlightRoute flightRoute, Plane plane) {
        this.departureTime = departureTime;
        this.route = flightRoute;
        this.plane = plane;
    }

    public void update(Date departureTime, FlightRoute flightRoute, Plane plane) {
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

    @JsonProperty("TotalBookings")
    public int flightOccupation() {
        return bookings.size();
    }

    @JsonProperty("seatsAvailable")
    public int seatsAvailable() {
        int totalSeats = plane.getTotalSeats();
        return bookings.size() <= totalSeats ? totalSeats - bookings.size() : 0;
    }

    @JsonProperty("customersBussinesClass")
    public List<Booking> customersForBussinesClass() {
        return bookings.stream().filter(booking ->
                        booking.getBookingClass().equals(BookingClass.BUSINESS))
                .collect(Collectors.toList());
    }

    @JsonProperty("customersEconomyClass")
    public List<Booking> customersForEconomyClass() {
        return bookings.stream().filter(booking ->
                        booking.getBookingClass().equals(BookingClass.BUSINESS))
                .collect(Collectors.toList());
    }

    @JsonProperty("customersFirstClass")
    public List<Booking> customersForFirstClass() {
        return bookings.stream().filter(booking ->
                        booking.getBookingClass().equals(BookingClass.FIRST))
                .collect(Collectors.toList());
    }

    public boolean flightExists(List<Flight> flights, Flight newFlight) {
        return flights.stream().anyMatch(existingFlight -> existingFlight.getDepartureTime().equals(newFlight.getDepartureTime()) &&
                existingFlight.getPlane().equals(newFlight.getPlane()) &&
                existingFlight.getRoute().equals(newFlight.getRoute()));
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
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
