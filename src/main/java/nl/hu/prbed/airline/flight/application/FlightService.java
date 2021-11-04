package nl.hu.prbed.airline.flight.application;

import nl.hu.prbed.airline.flight.application.exception.FlightAlreadyExistsException;
import nl.hu.prbed.airline.flight.application.exception.FlightNotFoundException;
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
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final PlaneService planeService;
    private final FlightRouteService flightRouteService;
    private final BookingService bookingService;

    public FlightService(FlightRepository flightRepository,
                         PlaneService planeService,
                         FlightRouteService flightRouteService,
                         BookingService bookingService) {
        this.flightRepository = flightRepository;
        this.planeService = planeService;
        this.flightRouteService = flightRouteService;
        this.bookingService = bookingService;
    }

    public Flight createFlight(FlightDTO flightDTO) {
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
        return flightRepository.findById(id).orElseThrow(FlightNotFoundException::new);
    }

    public List<Flight> findFlightsByDeparture(LocalDateTime departure) {
        try {
            return flightRepository.findAllByDepartureTime(departure);
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing departure variable to send!");
        }
    }

    public Flight findFlightRouteAndDeparture(Date departure, Long flightRouteId) {
        try {
            FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightRouteId);
            return flightRepository.findByRouteAndDepartureTime(flightRoute, departure).orElseThrow(FlightNotFoundException::new);
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing input variables to send!");
        }
    }

    public Flight updateFlight(FlightDTO flightDTO) {
        try {
            Flight flight = findFlightById(flightDTO.flightId);
            FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.flightRouteId);
            Plane plane = planeService.getPlaneById(flightDTO.planeId);
            flight.update(flightDTO.departureTime, flightRoute, plane);
            flightRepository.save(flight);
            return flight;
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing input variables to send!");
        }
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteFlightById(id);
    }

    public void addBooking(FlightDTO flightDTO) {
        try {
            Booking booking = bookingService.findBookingById(flightDTO.bookingId);
            Flight flight = findFlightById(flightDTO.flightId);
            flight.addBooking(booking);
            flightRepository.save(flight);
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing input variables to send!");
        }
    }

}
