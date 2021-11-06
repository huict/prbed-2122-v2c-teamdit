package nl.hu.prbed.airline.flight.application;

import nl.hu.prbed.airline.booking.domain.BookingClass;
import nl.hu.prbed.airline.flight.application.exception.FlightAlreadyExistsException;
import nl.hu.prbed.airline.flight.application.exception.FlightNotFoundException;
import nl.hu.prbed.airline.flight.presentation.dto.FlightRequestDTO;
import nl.hu.prbed.airline.flightroute.application.FlightRouteService;
import nl.hu.prbed.airline.plane.application.PlaneService;
import nl.hu.prbed.airline.airline.application.exception.*;
import nl.hu.prbed.airline.flight.data.FlightRepository;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.flight.presentation.dto.FlightDTO;
import nl.hu.prbed.airline.booking.application.BookingService;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

//@Transactional
@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final PlaneService planeService;
    private final FlightRouteService flightRouteService;

    public FlightService(FlightRepository flightRepository,
                         PlaneService planeService,
                         FlightRouteService flightRouteService) {
        this.flightRepository = flightRepository;
        this.planeService = planeService;
        this.flightRouteService = flightRouteService;
    }

    public Flight createFlight(FlightRequestDTO flightDTO) {
        try {
            Plane plane = planeService.getPlaneById(flightDTO.planeId);
            FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.flightRouteId);
            Flight flight = new Flight(flightDTO.departureTime, flightRoute, plane);

            List<Flight> allFlights = this.findAllFlights();

            if (Flight.exists(allFlights, flight)) {
                throw new FlightAlreadyExistsException();
            }

            return flightRepository.save(flight);

        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing some input variables to send!");
        }
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(FlightNotFoundException::new);
    }

    public List<Flight> findFlightsByDeparture(LocalDateTime departure) {
        try {
            return flightRepository.findAllByDepartureTime(departure);
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing departure variable to send!");
        }
    }

    public Flight findFlightRouteAndDeparture(LocalDateTime departure, Long flightRouteId) {
        try {
            FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightRouteId);
            return flightRepository.findByRouteAndDepartureTime(flightRoute, departure).orElseThrow(FlightNotFoundException::new);
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing input variables to send!");
        }
    }

    public Flight updateFlight(FlightRequestDTO flightDTO) {
        try {
            FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.flightRouteId);
            Plane plane = planeService.getPlaneById(flightDTO.planeId);
            Flight flight = flightDTO.toFlight(flightDTO.flightId, plane,flightRoute,flightDTO.departureTime);
            flightRepository.saveAndFlush(flight);
            return flight;
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing input variables to send!");
        }
    }

    public void deleteFlightById(Long id) {
        findFlightById(id);
        flightRepository.deleteById(id);
    }

}
