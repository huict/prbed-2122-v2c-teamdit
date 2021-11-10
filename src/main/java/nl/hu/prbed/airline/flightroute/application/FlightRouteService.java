package nl.hu.prbed.airline.flightroute.application;

import nl.hu.prbed.airline.airport.application.AirportService;
import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.flightroute.application.exception.FlightRouteAlreadyExistsException;
import nl.hu.prbed.airline.flightroute.application.exception.FlightRouteNotFoundException;
import nl.hu.prbed.airline.flightroute.data.FlightRouteRepository;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.flightroute.presentation.dto.FlightRouteDTO;
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

    public List<FlightRoute> getFlightRouteByArrivalLocation(String codeICAO){
        Airport airport = airportService.findAirportByCodeICAO(codeICAO);
        return flightRouteRepository.findAllByArrivalLocation(airport);
    }

    public List<FlightRoute> getFlightRouteByDepartureLocation(String codeICAO){
        Airport airport = airportService.findAirportByCodeICAO(codeICAO);
        return flightRouteRepository.findAllByDepartureLocation(airport);
    }


    public FlightRouteDTO getFlightRouteByID(Long id) {
        FlightRoute flightRoute = this.flightRouteRepository.findById(id)
                .orElseThrow(FlightRouteNotFoundException::new);
        return new FlightRouteDTO(flightRoute);
    }


    public FlightRouteDTO createFlightRoute(FlightRouteDTO flightRouteDTO) {
        Airport arrival = airportService.findAirportByCodeICAO(flightRouteDTO.arrivalCodeICAO);
        Airport departure = airportService.findAirportByCodeICAO(flightRouteDTO.departureCodeICAO);
        if (this.flightRouteRepository.existsByDepartureLocationAndArrivalLocationAndDurationMinutesAndPriceEconomyAndPriceBusinessAndPriceFirstClass(arrival, departure, flightRouteDTO.durationMinutes, flightRouteDTO.priceEconomy, flightRouteDTO.priceBusiness, flightRouteDTO.priceFirstClass)) {
            throw new FlightRouteAlreadyExistsException();
        }

        FlightRoute flightRoute = flightRouteDTO.toFlightroute(arrival, departure);

        this.flightRouteRepository.saveAndFlush(flightRoute);
        FlightRoute flightRouteResult = this.flightRouteRepository.findByDepartureLocationAndArrivalLocationAndDurationMinutesAndPriceEconomyAndPriceBusinessAndPriceFirstClass(arrival, departure, flightRouteDTO.durationMinutes, flightRouteDTO.priceEconomy, flightRouteDTO.priceBusiness, flightRouteDTO.priceFirstClass)
                .orElseThrow(FlightRouteNotFoundException::new);

        return new FlightRouteDTO(flightRouteResult);
    }


    public FlightRouteDTO updateFlightRoute(FlightRouteDTO flightRouteDTO) {
        if (flightRouteDTO.id == null) {
            throw new FlightRouteNotFoundException();
        }

        Airport arrival = airportService.findAirportByCodeICAO(flightRouteDTO.arrivalCodeICAO);
        Airport departure = airportService.findAirportByCodeICAO(flightRouteDTO.departureCodeICAO);

        FlightRoute flightRoute = flightRouteDTO.toFlightroute(flightRouteDTO.id, arrival, departure);

        this.flightRouteRepository.findById(flightRoute.getId())
                .orElseThrow(FlightRouteNotFoundException::new);

        this.flightRouteRepository.saveAndFlush(flightRoute);
        return new FlightRouteDTO(flightRoute);
    }


    public FlightRoute findFlightRouteByID(Long id) {
        return flightRouteRepository.findById(id).orElseThrow(FlightRouteNotFoundException::new);
    }

    public void deleteFlightRoute(Long id) {
        this.flightRouteRepository.findById(id)
                .orElseThrow(FlightRouteNotFoundException::new);
        this.flightRouteRepository.deleteById(id);
    }
}
