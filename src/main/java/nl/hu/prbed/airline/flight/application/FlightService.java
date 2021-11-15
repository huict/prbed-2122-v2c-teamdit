package nl.hu.prbed.airline.flight.application;

import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.flight.presentation.dto.FlightRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    Flight createFlight(FlightRequestDTO flightDTO);

    List<Flight> findAllFlights();

    Flight findFlightById(Long id);

    List<Flight> findAvailableFlights();

    List<Flight> findFlightsByFilter(LocalDateTime departureTime, String departureLocation, String arrivalLocation);

    Flight findFlightRouteAndDeparture(String role, LocalDateTime departure, Long flightRouteId);

    Flight updateFlight(FlightRequestDTO flightDTO);

    void deleteFlightById(Long id);

    List<Flight> getFlightsById(List<Long> ids);
}
