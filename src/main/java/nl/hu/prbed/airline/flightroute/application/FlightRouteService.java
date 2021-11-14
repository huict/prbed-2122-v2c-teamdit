package nl.hu.prbed.airline.flightroute.application;

import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.flightroute.presentation.dto.FlightRouteRequestDTO;
import nl.hu.prbed.airline.flightroute.presentation.dto.FlightRouteResponseDTO;

import java.util.List;

public interface FlightRouteService {
    List<FlightRouteResponseDTO> getAllFlightRoutes();
    List<FlightRoute> getFlightRouteByArrivalLocation(String codeICAO);
    List<FlightRoute> getFlightRouteByDepartureLocation(String codeICAO);
    FlightRouteResponseDTO getFlightRouteByID(Long id);
    FlightRouteResponseDTO createFlightRoute(FlightRouteRequestDTO flightRouteRequestDTO);
    FlightRouteResponseDTO updateFlightRoute(FlightRouteRequestDTO flightRouteRequestDTO);
    FlightRoute findFlightRouteByID(Long id);
    void deleteFlightRoute(Long id);
}
