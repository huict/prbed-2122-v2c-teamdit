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
    public List<FlightrouteDTO> getAllFlightroutes(){
        return this.flightRouteService.getAllFlightroutes();
    }

    @GetMapping("/{id}")
    public FlightrouteDTO getFlightrouteById(@PathVariable Long id) {
        return this.flightRouteService.getFlightrouteByID(id);
    }

    @PostMapping
    public FlightrouteDTO addFlightroute(@Validated @RequestBody FlightrouteDTO flightRouteDTO) {
        return this.flightRouteService.createFlightroute(flightRouteDTO);
    }

    @PutMapping
    public FlightrouteDTO updateFlightroute(@Validated @RequestBody FlightrouteDTO flightRouteDTO) {
        return this.flightRouteService.updateFlightroute(flightRouteDTO);
    }

}
