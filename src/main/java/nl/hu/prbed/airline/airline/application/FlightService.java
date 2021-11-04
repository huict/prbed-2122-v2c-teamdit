package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.*;
import nl.hu.prbed.airline.airline.data.FlightRepository;
import nl.hu.prbed.airline.airline.domain.Booking;
import nl.hu.prbed.airline.airline.domain.Flight;
import nl.hu.prbed.airline.airline.domain.FlightRoute;
import nl.hu.prbed.airline.airline.domain.Plane;
import nl.hu.prbed.airline.airline.presentation.dto.FlightDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Transactional
@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final PlaneService planeService;
    private final FlightRouteService flightRouteService;
    private final BookingService bookingService;

    public FlightService(FlightRepository fR, PlaneService pS, FlightRouteService fRS, BookingService bS) {
        this.flightRepository = fR;
        this.flightRouteService = fRS;
        this.bookingService = bS;
        this.planeService = pS;
    }

    public Flight createFlight(FlightDTO flightDTO) {
        try {
            Plane plane = planeService.getPlane(flightDTO.planeId);
            FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.flightRouteId);
            Flight flight = new Flight(flightDTO.departureTime, flightRoute, plane);

            if (!flight.flightExists(findAllFlights(), flight)) return flightRepository.save(flight);
            throw new FlightAlreadyExistsException();

        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing some input variables to send!");
        }
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findFlightById(Long id) {
        try {
            return flightRepository.findById(id).orElseThrow(FlightNotFoundException::new);
        } catch (NullPointerException nullPointerException) {
            throw new InvalidInputException("No id specified!");
        }
    }

    public List<Flight> findFlightsByDeparture(Date departure) {
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
            Plane plane = planeService.getPlane(flightDTO.planeId);
            flight.update(flightDTO.departureTime, flightRoute, plane);
            flightRepository.save(flight);
            return flight;
        } catch (NullPointerException nullPointerException) {
            throw new InvalidDTOException("Missing input variables to send!");
        }
    }

    public void deleteFlightById(Long id) {
        try {
            flightRepository.findById(id);
            flightRepository.deleteFlightById(id);
        } catch (NullPointerException nullPointerException) {
            throw new InvalidInputException("No id specified!");
        }
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
