package nl.hu.prbed.airline.flight.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.domain.BookingClass;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


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
    private FlightRoute route;

    @OneToOne
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

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || getClass() != object.getClass())
            return false;

        Flight flight = (Flight) object;
        return Objects.equals(departureTime, flight.departureTime)
                && Objects.equals(route, flight.route)
                && Objects.equals(plane, flight.plane);
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
