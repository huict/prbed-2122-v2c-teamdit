package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.FlightService;
import nl.hu.prbed.airline.airline.domain.Flight;
import nl.hu.prbed.airline.airline.presentation.dto.Flight.FlightBookingDTO;
import nl.hu.prbed.airline.airline.presentation.dto.Flight.FlightDTO;
import nl.hu.prbed.airline.airline.presentation.dto.Flight.FlightDepartureDTO;
import nl.hu.prbed.airline.airline.presentation.dto.Flight.FlightDepartureRouteDTO;
import org.springframework.web.bind.annotation.*;

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
    public List<Flight> getFlightsByDeparture(@RequestBody FlightDepartureDTO flightDeparture) {
        return this.flightService.findFlightsByDeparture(flightDeparture.departureTime);
    }

    @GetMapping("/departure/route")
    public Flight getFlightRouteAndDeparture(@RequestBody FlightDepartureRouteDTO flightDepartureRoute) {
        return this.flightService.findFlightRouteAndDeparture(flightDepartureRoute);
    }

    @PostMapping
    public Flight addFlight(@RequestBody FlightDTO flightDTO) {
        return flightService.createFlight(flightDTO);
    }

    @PutMapping("/{id}")
    public Flight updateFlightById(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        return flightService.updateFlight(flightDTO, id);
    }

    @PutMapping("/booking")
    public void addBooking(@RequestBody FlightBookingDTO flightBooking){
        flightService.addBooking(flightBooking);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightById(@PathVariable Long id) {
        flightService.deleteFlightById(id);
    }

}

/*NOTE: een flight kan alleen een vluchttijd veranderen ivm vertraging, want dit is de enige field die klasse Flight zelf ter beschikking heeft
    de andere fields geven een relatie naar een andere klasse aan,
     omdat er gebruikt wordt gemaakt van cascade.ALL worden deze wijzigingen ook doorgevoerd naar de andere klassen
     Het enige was er nog toegevoegd kan worden is een booking id, en het wijzigen van tijd.*/
