package nl.hu.prbed.airline.flight.presentation.dto;

import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.plane.domain.Plane;

import java.time.LocalDateTime;

@NoArgsConstructor
public class FlightRequestDTO {
    public Long flightId;
    public Long flightRouteId;
    public Long planeId;
    public LocalDateTime departureTime;

    public Flight toFlight(Long id, Plane plane, FlightRoute flightRoute, LocalDateTime departureTime) {
        return new Flight(id, departureTime, flightRoute, plane);
    }

}
