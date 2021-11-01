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
        if (this.flightRouteRepository.existsById(flightRouteDTO.id)) {
            throw new FlightRouteAlreadyExistsException(flightRouteDTO.id);
        }

        Airport arrival = airportService.findAirportByCode(flightRouteDTO.arrivalCode);
        Airport departure = airportService.findAirportByCode(flightRouteDTO.departureCode);

        this.flightRouteRepository.save(flightRouteDTO.toFlightroute(arrival, departure));

        return flightRouteDTO;
    }

    public FlightrouteDTO updateFlightRoute(FlightrouteDTO flightRouteDTO) {
        this.flightRouteRepository.findById(flightRouteDTO.id)
                .orElseThrow(() -> new FlightRouteNotFoundException(flightRouteDTO.id));
        Airport arrival = airportService.findAirportByCode(flightRouteDTO.arrivalCode);
        Airport departure = airportService.findAirportByCode(flightRouteDTO.departureCode);

        this.flightRouteRepository.saveAndFlush(flightRouteDTO.toFlightroute(arrival, departure));
        return flightRouteDTO;
    }

    public void deleteFlightRoute(Long id) {
        this.flightRouteRepository.deleteById(id);
    }
}
