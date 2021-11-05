package nl.hu.prbed.airline.flightroute.application;

import nl.hu.prbed.airline.flightroute.application.exception.FlightRouteAlreadyExistsException;
import nl.hu.prbed.airline.flightroute.application.exception.FlightRouteNotFoundException;
import nl.hu.prbed.airline.flightroute.data.FlightRouteRepository;
import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.flightroute.presentation.dto.FlightRouteDTO;
import nl.hu.prbed.airline.airport.application.AirportService;
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

    public List<FlightRouteDTO> getAllFlightRoutes() {

        List<FlightRoute> flightRoutes = this.flightRouteRepository.findAll();
        List<FlightRouteDTO> flightRouteDTOS = new ArrayList<>();
        for (FlightRoute flightRoute : flightRoutes) {
            flightRouteDTOS.add(new FlightRouteDTO(flightRoute));
        }
        return flightRouteDTOS;
    }

    public FlightRouteDTO getFlightRouteByID(Long id) {
        FlightRoute flightRoute = this.flightRouteRepository.findById(id)
                .orElseThrow(FlightRouteNotFoundException::new);
        return new FlightRouteDTO(flightRoute);
    }


    public FlightRouteDTO createFlightRoute(FlightRouteDTO flightRouteDTO) {
        Airport arrival = airportService.findAirportByCode(flightRouteDTO.arrivalCode);
        Airport departure = airportService.findAirportByCode(flightRouteDTO.departureCode);
        FlightRoute flightRoute = flightRouteDTO.toFlightroute(arrival, departure);


        //todo: HAS TO BE A BETTER WAY
        List<FlightRoute> flightRoutes = this.flightRouteRepository.findAll();
        FlightRoute existingFlightRoute = this.flightRouteRepository.findByDepartureLocationAndArrivalLocationAndDurationMinutesAndPriceEconomyAndPriceBusinessAndPriceFirstClass()
        Object potentialFlightRoute = flightRoute.flightExists(flightRoutes, flightRoute);

        if (!(potentialFlightRoute instanceof Boolean)) {
            FlightRoute existingFLightRoute = (FlightRoute) potentialFlightRoute;
            throw new FlightRouteAlreadyExistsException(existingFLightRoute.getId());
        }

        this.flightRouteRepository.save(flightRouteDTO.toFlightroute(arrival, departure));

        flightRoutes = this.flightRouteRepository.findAll();
        Object addedFlightRoute = flightRoute.flightExists(flightRoutes, flightRoute);

        return new FlightRouteDTO((FlightRoute) addedFlightRoute);
    }

    public FlightRouteDTO updateFlightRoute(FlightRouteDTO flightRouteDTO) {
        Airport arrival = airportService.findAirportByCode(flightRouteDTO.arrivalCode);
        Airport departure = airportService.findAirportByCode(flightRouteDTO.departureCode);

        if (flightRouteDTO.id == null){
            throw new FlightRouteNotFoundException();
        }

        FlightRoute flightRoute = flightRouteDTO.toFlightroute(flightRouteDTO.id, arrival, departure);

        this.flightRouteRepository.findById(flightRoute.getId())
                .orElseThrow(FlightRouteNotFoundException::new);

        this.flightRouteRepository.saveAndFlush(flightRoute);
        return new FlightRouteDTO(flightRoute);
    }

    public FlightRoute findFlightRouteByID(Long id ){
        return flightRouteRepository.findById(id).orElseThrow(FlightRouteNotFoundException::new);
    }
    public void deleteFlightRoute(Long id) {
        this.flightRouteRepository.findById(id)
                .orElseThrow(FlightRouteNotFoundException::new);
        this.flightRouteRepository.deleteById(id);
    }
}
