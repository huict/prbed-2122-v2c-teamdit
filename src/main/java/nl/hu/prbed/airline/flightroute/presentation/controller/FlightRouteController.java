package nl.hu.prbed.airline.flightroute.presentation.controller;

import nl.hu.prbed.airline.flightroute.application.FlightRouteService;
import nl.hu.prbed.airline.flightroute.presentation.dto.DTO;
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
    public List<DTO> getAllFlightRoutes() {
        return this.flightRouteService.getAllFlightRoutes();
    }

    @GetMapping("/{id}")
    public DTO getFlightrouteById(@PathVariable Long id) {
        return this.flightRouteService.getFlightRouteByID(id);
    }

    @PostMapping
    public DTO addFlightroute(@Validated @RequestBody DTO flightRouteDTO) {
        return this.flightRouteService.createFlightRoute(flightRouteDTO);
    }

    @PutMapping
    public DTO updateFlightroute(@Validated @RequestBody DTO flightRouteDTO) {
        return this.flightRouteService.updateFlightRoute(flightRouteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightRouteById(@PathVariable Long id) {
        this.flightRouteService.deleteFlightRoute(id);
    }
}
