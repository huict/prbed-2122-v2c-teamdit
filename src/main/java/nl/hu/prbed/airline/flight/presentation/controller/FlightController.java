package nl.hu.prbed.airline.flight.presentation.controller;

import nl.hu.prbed.airline.flight.application.FlightService;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.flight.presentation.dto.FlightDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return this.flightService.findAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.findFlightById(id);
    }

    @GetMapping("/departure")
    public List<Flight> getFlightsByDeparture(@RequestBody FlightDTO flightDTO) {
        return this.flightService.findFlightsByDeparture(flightDTO.departureTime);
    }


    @GetMapping("/departure/route")
    public Flight getFlightRouteAndDeparture(@RequestParam(name = "departure") LocalDateTime departure, @RequestParam(name = "route") Long routeId) {
        return this.flightService.findFlightRouteAndDeparture(departure, routeId);
    }

    @PostMapping
    public Flight addFlight(@RequestBody FlightDTO flightDTO) {
        return flightService.createFlight(flightDTO);
    }

    @PutMapping("/{id}")
    public Flight updateFlightById(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        return flightService.updateFlight(flightDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightById(@PathVariable Long id) {
        flightService.deleteFlightById(id);
    }

}


// get by departure
//  @GetMapping
//    public List<Flight> getFlightsByDeparture(@RequestParam(name = "departure") LocalDateTime departure) {
//        return this.flightService.findFlightsByDeparture(departure);
//    }



// get by flightroute and departure
//  @GetMapping
//    public Flight getFlightRouteAndDeparture(@RequestParam(name = "departure") Date departure, @RequestParam(name = "route") Long routeId) {
//        return this.flightService.findFlightRouteAndDeparture(departure, routeId);
//    }
