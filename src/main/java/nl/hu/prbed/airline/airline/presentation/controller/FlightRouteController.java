package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.FlightRouteService;
import nl.hu.prbed.airline.airline.presentation.dto.FlightrouteDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/flightroute")
public class FlightRouteController {
    private final FlightRouteService flightRouteService;

    public FlightRouteController(FlightRouteService flightRouteService) {
        this.flightRouteService = flightRouteService;
    }

    @GetMapping
    public List<FlightrouteDTO> getAllFlightRoutes() {
        return this.flightRouteService.getAllFlightRoutes();
    }

    @GetMapping("/{id}")
    public FlightrouteDTO getFlightrouteById(@PathVariable Long id) {
        return this.flightRouteService.getFlightRouteByID(id);
    }

    @PostMapping
    public FlightrouteDTO addFlightroute(@Validated @RequestBody FlightrouteDTO flightRouteDTO) {
        return this.flightRouteService.createFlightRoute(flightRouteDTO);
    }

    @PutMapping
    public FlightrouteDTO updateFlightroute(@Validated @RequestBody FlightrouteDTO flightRouteDTO) {
        return this.flightRouteService.updateFlightRoute(flightRouteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightRouteById(@PathVariable Long id) {
        this.flightRouteService.deleteFlightRoute(id);
    }
}
