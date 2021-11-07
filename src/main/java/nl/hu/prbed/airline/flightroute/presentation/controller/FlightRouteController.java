package nl.hu.prbed.airline.flightroute.presentation.controller;

import nl.hu.prbed.airline.flightroute.application.FlightRouteService;
import nl.hu.prbed.airline.flightroute.application.exception.FlightRouteAlreadyExistsException;
import nl.hu.prbed.airline.flightroute.application.exception.FlightRouteNotFoundException;
import nl.hu.prbed.airline.flightroute.presentation.dto.FlightRouteDTO;
import nl.hu.prbed.airline.flightroute.presentation.exception.FlightRouteAlreadyExistsHTTPException;
import nl.hu.prbed.airline.flightroute.presentation.exception.FlightRouteNotFoundHTTPException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/flightroute")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class FlightRouteController {
    private final FlightRouteService flightRouteService;

    public FlightRouteController(FlightRouteService flightRouteService) {
        this.flightRouteService = flightRouteService;
    }

    @GetMapping
    public List<FlightRouteDTO> getAllFlightRoutes() {
        return this.flightRouteService.getAllFlightRoutes();
    }

    @GetMapping("/{id}")
    public FlightRouteDTO getFlightrouteById(@PathVariable Long id) {
        try {
            return this.flightRouteService.getFlightRouteByID(id);
        }
        catch (FlightRouteNotFoundException e){
            throw new FlightRouteNotFoundHTTPException();
        }
    }

    @PostMapping
    public FlightRouteDTO addFlightroute(@Validated @RequestBody FlightRouteDTO flightRouteDTO) {
        try {
            return this.flightRouteService.createFlightRoute(flightRouteDTO);
        } catch (FlightRouteAlreadyExistsException e){
            throw new FlightRouteAlreadyExistsHTTPException();
        }
    }

    @PutMapping
    public FlightRouteDTO updateFlightroute(@Validated @RequestBody FlightRouteDTO flightRouteDTO) {
        try {
            return this.flightRouteService.updateFlightRoute(flightRouteDTO);
        }
        catch (FlightRouteNotFoundException e){
            throw new FlightRouteNotFoundHTTPException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFlightRouteById(@PathVariable Long id) {
        try{
            this.flightRouteService.deleteFlightRoute(id);
        }
        catch (FlightRouteNotFoundException e){
            throw new FlightRouteNotFoundHTTPException();
        }
    }
}
