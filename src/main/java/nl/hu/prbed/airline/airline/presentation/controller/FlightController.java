package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.FlightService;
import nl.hu.prbed.airline.airline.domain.Flight;
import nl.hu.prbed.airline.airline.domain.FlightRoute;
import nl.hu.prbed.airline.airline.domain.Plane;
import nl.hu.prbed.airline.airline.presentation.dto.FlightDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    //Get all flights
    @GetMapping
    public List<Flight> getAllFlights(){
        return this.flightService.findAllFlights();
    }

    //Get flights based on departure
    @GetMapping("/departure")
    public List<Flight> getFlightsByDeparture(@RequestBody LocalDateTime departure){
        return this.flightService.findFlightsByDeparture(departure);
    }

    //Get flight based on departure and route
    @GetMapping("/departure/route")
    public Flight getFlightRouteAndDeparture(@RequestBody FlightDTO flightDTO){
        return this.flightService.findFlightRouteAndDeparture(flightDTO);
    }

    //Add flight
    @PostMapping
    public Flight addFlight(@RequestBody FlightDTO flightDTO){
        System.out.println("CONSOLE MESSAGE ALERT:");
        System.out.println(flightDTO.flightRouteId);
        System.out.println(flightDTO.planeId);
        System.out.println(flightDTO.departureTime);

        return flightService.createFlight(flightDTO);
    }

    //Update flight
//    public Flight updateFlight(FlightDTO flightDTO){
//        return  flightService.updateFlight(flightDTO);
//    }

}
