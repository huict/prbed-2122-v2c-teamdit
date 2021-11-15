package nl.hu.prbed.airline.flight.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.plane.domain.Plane;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureTime, flight.departureTime)
                && Objects.equals(route, flight.route)
                && Objects.equals(plane, flight.plane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departureTime, route, plane);
    }

    public static boolean exists(List<Flight> flights, Flight newFlight) {
        for (Flight flight : flights) {
            if (flight.equals(newFlight)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\ndeparture-time: " + departureTime +
                "\nroute: \n" + route +
                "\nplane: \n" + plane;
    }
}
