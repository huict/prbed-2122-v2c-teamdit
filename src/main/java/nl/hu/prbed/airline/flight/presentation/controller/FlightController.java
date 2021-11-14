package nl.hu.prbed.airline.flight.presentation.controller;

import nl.hu.prbed.airline.flight.presentation.exception.FlightInUseHTTPException;
import nl.hu.prbed.airline.flight.application.FlightService;
import nl.hu.prbed.airline.flight.application.FlightServiceImpl;
import nl.hu.prbed.airline.flight.application.exception.FlightAlreadyExistsException;
import nl.hu.prbed.airline.flight.application.exception.FlightNotFoundException;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.flight.presentation.dto.FlightRequestDTO;
import nl.hu.prbed.airline.flight.presentation.dto.FlightResponseDTO;
import nl.hu.prbed.airline.flight.presentation.exception.FlightAlreadyExistsHTTPException;
import nl.hu.prbed.airline.flight.presentation.exception.FlightNotFoundHTTPException;
import nl.hu.prbed.airline.flightroute.application.exception.FlightRouteNotFoundException;
import nl.hu.prbed.airline.flightroute.presentation.exception.FlightRouteNotFoundHTTPException;
import nl.hu.prbed.airline.plane.application.exception.PlaneNotFoundException;
import nl.hu.prbed.airline.plane.presentation.exception.PlaneNotFoundHTTPException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/flight")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights(@RequestParam(name = "departure", required = false)
                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departure,
                                      @RequestParam(name = "departureLocation", required = false) String departureLocation,
                                      @RequestParam(name = "arrivalLocation", required = false) String arrivalLocation) {
        return this.flightService.findFlightsByFilter(departure, departureLocation, arrivalLocation);
    }

    @GetMapping("/available")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Flight> getAllAvailableFlights() {
        return this.flightService.findAvailableFlights();
    }

    @GetMapping("/{id}")
    public FlightResponseDTO getFlightById(@PathVariable Long id) {
        try {
            Flight flight = flightService.findFlightById(id);
            return new FlightResponseDTO(flight);
        } catch (FlightNotFoundException e) {
            throw new FlightNotFoundHTTPException();
        }
    }

    @GetMapping("/route")
    @PreAuthorize("hasRole('ROLE_USER')")
    public FlightResponseDTO getFlightRouteAndDeparture(Authentication authentication,
                                                        @RequestParam(name = "departure")
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                LocalDateTime departure,
                                                        @RequestParam(name = "route") Long routeId) {
        try {
            String role = authentication.getAuthorities().toString();
            Flight flight = flightService.findFlightRouteAndDeparture(role, departure, routeId);
            return new FlightResponseDTO(flight);
        } catch (FlightNotFoundException e) {
            throw new FlightNotFoundHTTPException();
        }

    }

    @PostMapping
    public FlightResponseDTO addFlight(@RequestBody FlightRequestDTO flightRequestDTO) {
        try {
            Flight flight = flightService.createFlight(flightRequestDTO);
            return new FlightResponseDTO(flight);
        } catch (FlightAlreadyExistsException flightAlreadyExistsException) {
            throw new FlightAlreadyExistsHTTPException();
        } catch (PlaneNotFoundException planeNotFoundException) {
            throw new PlaneNotFoundHTTPException(flightRequestDTO.planeId);
        } catch (FlightRouteNotFoundException e) {
            throw new FlightRouteNotFoundHTTPException();
        }
    }

    @PutMapping
    public FlightResponseDTO updateFlightById(@RequestBody FlightRequestDTO flightRequestDTO) {
        try {
            Flight flight = flightService.updateFlight(flightRequestDTO);
            return new FlightResponseDTO(flight);
        } catch (FlightNotFoundException e) {
            throw new FlightNotFoundHTTPException();
        } catch (PlaneNotFoundException e) {
            throw new PlaneNotFoundHTTPException(flightRequestDTO.planeId);
        } catch (FlightRouteNotFoundException e){
            throw new FlightRouteNotFoundHTTPException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFlightById(@PathVariable Long id) {
        try {
            flightService.deleteFlightById(id);
        } catch (FlightNotFoundException e) {
            throw new FlightNotFoundHTTPException();
        } catch (DataIntegrityViolationException e) {
            throw new FlightInUseHTTPException();
        }
    }

}
