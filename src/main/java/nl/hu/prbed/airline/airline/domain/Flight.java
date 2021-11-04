package nl.hu.prbed.airline.airline.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Component
@NoArgsConstructor
@Getter
public class Flight {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    // TODO: Cleanup new list initialization on object creation
    @OneToMany
    private List<Booking> bookings = new ArrayList<>();

    private LocalDateTime departureTime;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private FlightRoute route;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Plane plane;

    public Flight(LocalDateTime departureTime, FlightRoute flightRoute, Plane plane) {
        this.departureTime = departureTime;
        this.route = flightRoute;
        this.plane = plane;
    }

    public void update(LocalDateTime departureTime, FlightRoute flightRoute, Plane plane) {
        this.departureTime = departureTime;
        this.route = flightRoute;
        this.plane = plane;
    }

    public void addBooking(Booking booking) {
        if (seatsLeftForClass(booking.getBookingClass()) > booking.getAmountOfPassengers()) {
            bookings.add(booking);
        } else {
            // TODO: Throw noSeatsLeftForThisClass
        }
    }

    public int seatsLeftForClass(BookingClass bookingClass) {
        int seatsLeft = 0;

        for (Booking booking : this.bookings) {
            if (booking.getBookingClass().equals(bookingClass)) {
                seatsLeft += booking.getAmountOfPassengers();
            }
        }

        return seatsLeft;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }


    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setRoute(FlightRoute route) {
        this.route = route;
    }


    public boolean equals(Flight flight) {
        return flight.getDepartureTime().equals(this.departureTime) &&
                flight.getRoute().equals(this.route) &&
                flight.getPlane().equals(this.plane);
    }

    public static boolean exists(List<Flight> flights, Flight newFlight) {
        for (Flight flight : flights) {
            if (flight.equals(newFlight)) {
                return true;
            }
        }

        return false;
    }
}
