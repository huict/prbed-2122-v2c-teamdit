package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.FlightRouteAlreadyExistsException;
import nl.hu.prbed.airline.airline.application.exception.FlightRouteNotFoundException;
import nl.hu.prbed.airline.airline.data.FlightRouteRepository;
import nl.hu.prbed.airline.airline.domain.Airport;
import nl.hu.prbed.airline.airline.domain.FlightRoute;
import nl.hu.prbed.airline.airline.presentation.dto.FlightrouteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightRouteService {
    private final FlightRouteRepository flightRouteRepository;
    private final AirportService airportService;

    public FlightRouteService(FlightRouteRepository flightRouteRepository, AirportService airportService) {
        this.flightRouteRepository = flightRouteRepository;
        this.airportService = airportService;
    }

    public List<FlightrouteDTO> getAllFlightRoutes() {

        List<FlightRoute> flightRoutes = this.flightRouteRepository.findAll();
        List<FlightrouteDTO> flightRouteDTOS = new ArrayList<>();
        for (FlightRoute flightRoute : flightRoutes) {
            flightRouteDTOS.add(new FlightrouteDTO(flightRoute));
        }
        return flightRouteDTOS;
    }

    public FlightrouteDTO getFlightRouteByID(Long id) {
        FlightRoute flightRoute = this.flightRouteRepository.findById(id)
                .orElseThrow(() -> new FlightRouteNotFoundException(id));
        return new FlightrouteDTO(flightRoute);
    }


    public FlightrouteDTO createFlightRoute(FlightrouteDTO flightRouteDTO) {
        Airport arrival = airportService.findAirportByCode(flightRouteDTO.arrivalCode);
        Airport departure = airportService.findAirportByCode(flightRouteDTO.departureCode);
        FlightRoute flightRoute = flightRouteDTO.toFlightroute(arrival, departure);

        if (this.flightRouteRepository.existsById(flightRoute.getId())) {
            throw new FlightRouteAlreadyExistsException(flightRoute.getId());
        }

        this.flightRouteRepository.save(flightRouteDTO.toFlightroute(arrival, departure));

        return new FlightrouteDTO(flightRoute);
    }

    public FlightrouteDTO updateFlightRoute(FlightrouteDTO flightRouteDTO) {
        Airport arrival = airportService.findAirportByCode(flightRouteDTO.arrivalCode);
        Airport departure = airportService.findAirportByCode(flightRouteDTO.departureCode);
        FlightRoute flightRoute = flightRouteDTO.toFlightroute(arrival, departure);

        this.flightRouteRepository.findById(flightRoute.getId())
                .orElseThrow(() -> new FlightRouteNotFoundException(flightRoute.getId()));

        this.flightRouteRepository.saveAndFlush(flightRoute);
        return new FlightrouteDTO(flightRoute);
    }

    public void deleteFlightRoute(Long id) {
        this.flightRouteRepository.deleteById(id);
    }
}
