package nl.hu.prbed.airline.flightroute.presentation.controller;

import nl.hu.prbed.airline.flightroute.application.FlightRouteService;
import nl.hu.prbed.airline.flightroute.presentation.dto.FlightRouteDTO;
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
    public List<FlightRouteDTO> getAllFlightRoutes() {
        return this.flightRouteService.getAllFlightRoutes();
    }

    @GetMapping("/{id}")
    public FlightRouteDTO getFlightrouteById(@PathVariable Long id) {
        return this.flightRouteService.getFlightRouteByID(id);
    }

    @PostMapping
    public FlightRouteDTO addFlightroute(@Validated @RequestBody FlightRouteDTO flightRouteDTO) {
        return this.flightRouteService.createFlightRoute(flightRouteDTO);
    }

    @PutMapping
    public FlightRouteDTO updateFlightroute(@Validated @RequestBody FlightRouteDTO flightRouteDTO) {
        return this.flightRouteService.updateFlightRoute(flightRouteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightRouteById(@PathVariable Long id) {
        this.flightRouteService.deleteFlightRoute(id);
    }
}
