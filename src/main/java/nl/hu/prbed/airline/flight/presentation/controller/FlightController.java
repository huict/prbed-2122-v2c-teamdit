package nl.hu.prbed.airline.flight.presentation.controller;

import nl.hu.prbed.airline.flight.application.FlightService;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.flight.presentation.dto.FlightDTO;
import nl.hu.prbed.airline.flight.presentation.dto.FlightRequestDTO;
import nl.hu.prbed.airline.flight.presentation.dto.FlightResponseDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/flight")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights(@RequestParam(name = "departure", required = false)
                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                      LocalDateTime departure) {
        return departure == null ? this.flightService.findAllFlights() : this.flightService.findFlightsByDeparture(departure);
    }

    @GetMapping("/{id}")
    public FlightResponseDTO getFlightById(@PathVariable Long id) {
        Flight flight = flightService.findFlightById(id);
        return new FlightResponseDTO(flight);
    }

    @GetMapping("/route")
    public FlightResponseDTO getFlightRouteAndDeparture(@RequestParam(name = "departure")
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                        LocalDateTime departure,
                                                        @RequestParam(name = "route") Long routeId) {
        Flight flight = flightService.findFlightRouteAndDeparture(departure, routeId);
        return new FlightResponseDTO(flight);
    }

    @PostMapping
    public FlightResponseDTO addFlight(@RequestBody FlightRequestDTO flightRequestDTO) {
        Flight flight = flightService.createFlight(flightRequestDTO);
        return new FlightResponseDTO(flight);
    }

    @PutMapping
    public FlightResponseDTO updateFlightById(@RequestBody FlightRequestDTO flightRequestDTO) {
        Flight flight = flightService.updateFlight(flightRequestDTO);
        return new FlightResponseDTO(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightById(@PathVariable Long id) {
        flightService.deleteFlightById(id);
    }

}
