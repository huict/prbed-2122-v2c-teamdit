package nl.hu.prbed.airline.flight.presentation.dto;

import java.time.LocalDateTime;


public class FlightDTO {

    public Long flightId;
    public Long flightRouteId;
    public Long planeId;
    public LocalDateTime departureTime;

    public FlightDTO(LocalDateTime departureTime, Long flightRouteId, Long planeId) {
        this.departureTime = departureTime;
        this.flightRouteId = flightRouteId;
        this.planeId = planeId;
    }
}
