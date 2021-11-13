package nl.hu.prbed.airline.flight.application;

import nl.hu.prbed.airline.airline.application.exception.InvalidDTOException;
import nl.hu.prbed.airline.flight.application.exception.FlightAlreadyExistsException;
import nl.hu.prbed.airline.flight.application.exception.FlightNotFoundException;
import nl.hu.prbed.airline.flight.application.filter.Criteria;
import nl.hu.prbed.airline.flight.application.filter.CriteriaArrivalLocation;
import nl.hu.prbed.airline.flight.application.filter.CriteriaDepartureLocation;
import nl.hu.prbed.airline.flight.application.filter.CriteriaDepartureTime;
import nl.hu.prbed.airline.flight.data.FlightRepository;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.flight.presentation.dto.FlightRequestDTO;
import nl.hu.prbed.airline.flightroute.application.FlightRouteService;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.plane.application.PlaneService;
import nl.hu.prbed.airline.plane.domain.Plane;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final PlaneService planeService;
    private final FlightRouteService flightRouteService;

    public FlightServiceImpl(FlightRepository flightRepository,
                             PlaneService planeService,
                             FlightRouteService flightRouteService) {
        this.flightRepository = flightRepository;
        this.planeService = planeService;
        this.flightRouteService = flightRouteService;
    }

    public Flight createFlight(FlightRequestDTO flightDTO) {
        Flight flight;
        try {
            Plane plane = planeService.getPlaneById(flightDTO.planeId);
            FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.flightRouteId);
            flight = new Flight(flightDTO.departureTime, flightRoute, plane);
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing required information from DTO");
        }

        List<Flight> allFlights = this.findAllFlights();

        if (Flight.exists(allFlights, flight)) {
            throw new FlightAlreadyExistsException();
        }

        return flightRepository.save(flight);
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(FlightNotFoundException::new);
    }

    public List<Flight> findAvailableFlights() {
        try {
            LocalDateTime dateTimeNow = LocalDateTime.now();
            return flightRepository.findAllByDepartureTimeAfter(dateTimeNow);
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing departure variable to send!");
        }
    }

    public List<Flight> findFlightsByFilter(LocalDateTime departureTime, String departureLocation, String arrivalLocation) {
        List<Flight> allFlights = new ArrayList<>(this.findAllFlights());
        List<Flight> filterResult;

        Criteria departureTimeFilter = new CriteriaDepartureTime();
        Criteria departureLocationFilter = new CriteriaDepartureLocation();
        Criteria arrivalLocationFilter = new CriteriaArrivalLocation();

        if (departureTime != null) {
            filterResult = departureTimeFilter.meetCriteria(allFlights, departureTime);
        } else {
            filterResult = allFlights;
        }

        if (departureLocation != null) {
            filterResult = departureLocationFilter.meetCriteria(filterResult, departureLocation);
        }

        if (arrivalLocation != null) {
                    filterResult = arrivalLocationFilter.meetCriteria(filterResult, departureLocation);
        }

        return filterResult;
    }

    public Flight findFlightRouteAndDeparture(String role, LocalDateTime departure, Long flightRouteId) {
        try {
            FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightRouteId);

            if (Objects.equals(role, "[ROLE_USER]")) {
                LocalDateTime dateTimeNow = LocalDateTime.now();

                return flightRepository.findByRouteAndDepartureTimeAfter(flightRoute, dateTimeNow)
                        .orElseThrow(FlightNotFoundException::new);
            } else {

                return flightRepository.findByRouteAndDepartureTime(flightRoute, departure)
                        .orElseThrow(FlightNotFoundException::new);
            }
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing input variables to send!");
        }
    }

    public Flight updateFlight(FlightRequestDTO flightDTO) {
        try {
            FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.flightRouteId);
            Plane plane = planeService.getPlaneById(flightDTO.planeId);
            Flight flight = flightDTO.toFlight(flightDTO.flightId, plane, flightRoute, flightDTO.departureTime);
            flightRepository.saveAndFlush(flight);
            return flight;
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing input variables to send!");
        }
    }

    @Override
    public List<Flight> getFlightsById(List<Long> ids) {
        List<Flight> flights = new ArrayList<>();
        Flight flight;
        for(Long flightId : ids){
            try{
                flight = findFlightById(flightId);
            }
            catch (DataIntegrityViolationException e) {
                throw new FlightNotFoundException();
            }
            flights.add(flight);
        }

        return flights;
    }

    public void deleteFlightById(Long id) {
        findFlightById(id);
        flightRepository.deleteById(id);
    }
}