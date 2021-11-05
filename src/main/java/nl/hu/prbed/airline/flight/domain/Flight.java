package nl.hu.prbed.airline.flight.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.domain.BookingClass;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Component
@NoArgsConstructor
@Getter
public class Flight {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

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

    public Flight(Long id, LocalDateTime departureTime, FlightRoute flightRoute, Plane plane) {
        this(departureTime, flightRoute, plane);
        this.id = id;
    }


//    public int seatsLeftForClass(BookingClass bookingClass, Booking booking) {
//        int seatsLeft = 0;
//
//        for (Booking booking : this.bookings) {
//            if (booking.getBookingClass().equals(bookingClass)) {
//                seatsLeft += booking.getAmountOfPassengers();
//            }
//        }
//
//        return seatsLeft;
//    }


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

    public Long getId() {
        return id;
    }
}
