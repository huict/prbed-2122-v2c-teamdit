package nl.hu.prbed.airline.flight.presentation.dto;

import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.plane.domain.Plane;

import java.time.LocalDateTime;

public class FlightResponseDTO {
    public Long id;
    public FlightRoute flightRoute;
    public Plane plane;
    public LocalDateTime departureTime;

    public FlightResponseDTO() {
    }


    public FlightResponseDTO(Flight flight) {
        this.id = flight.getId();
        this.flightRoute = flight.getRoute();
        this.plane = flight.getPlane();
        this.departureTime = flight.getDepartureTime();

    }
}
