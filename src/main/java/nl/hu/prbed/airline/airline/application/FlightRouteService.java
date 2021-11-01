package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.FlightRouteAlreadyExistsException;
import nl.hu.prbed.airline.airline.application.exception.FlightRouteNotFoundException;
import nl.hu.prbed.airline.airline.data.FlightRouteRepository;
import nl.hu.prbed.airline.airline.domain.FlightRoute;
import nl.hu.prbed.airline.airline.presentation.dto.FlightrouteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightRouteService {
    private final FlightRouteRepository flightRouteRepository;

    public FlightRouteService(FlightRouteRepository flightRouteRepository) {
        this.flightRouteRepository = flightRouteRepository;
    }

    public List<FlightrouteDTO> getAllFlightroutes() {

        List<FlightRoute> flightRoutes = this.flightRouteRepository.findAll();
        List<FlightrouteDTO> flightRouteDTOS = new ArrayList<>();
        for (FlightRoute flightRoute : flightRoutes) {
            flightRouteDTOS.add(new FlightrouteDTO(flightRoute));
        }
        return flightRouteDTOS;
    }

    public FlightrouteDTO getFlightrouteByID(Long id) {
        FlightRoute flightRoute = this.flightRouteRepository.findById(id)
                .orElseThrow(() -> new FlightRouteNotFoundException(id));
        return new FlightrouteDTO(flightRoute);
    }


    public FlightrouteDTO createFlightroute(FlightrouteDTO flightRouteDTO) {
        if (this.flightRouteRepository.existsById(flightRouteDTO.id)) {
            throw new FlightRouteAlreadyExistsException(flightRouteDTO.id);
        }
        FlightRoute flightRoute = flightRouteDTO.toFlightroute();
        this.flightRouteRepository.save(flightRoute);
        return flightRouteDTO;
    }

    public FlightrouteDTO updateFlightroute(FlightrouteDTO flightRouteDTO) {
        FlightRoute updatedFlightroute = flightRouteDTO.toFlightroute();

        this.flightRouteRepository.findById(flightRouteDTO.id)
                .orElseThrow(() -> new FlightRouteNotFoundException(flightRouteDTO.id));
        this.flightRouteRepository.saveAndFlush(updatedFlightroute);
        return flightRouteDTO;
    }
}
