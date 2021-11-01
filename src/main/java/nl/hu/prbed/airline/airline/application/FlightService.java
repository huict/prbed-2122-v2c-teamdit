package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.data.FlightRepository;
import nl.hu.prbed.airline.airline.data.PlaneRepository;
import nl.hu.prbed.airline.airline.domain.Booking;
import nl.hu.prbed.airline.airline.domain.Flight;
import nl.hu.prbed.airline.airline.domain.FlightRoute;
import nl.hu.prbed.airline.airline.domain.Plane;
import nl.hu.prbed.airline.airline.presentation.dto.BookingDTO;
import nl.hu.prbed.airline.airline.presentation.dto.FlightDTO;
import nl.hu.prbed.airline.airline.presentation.dto.FlightRouteDTO;
import nl.hu.prbed.airline.airline.presentation.dto.PlaneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

//laten we de afweging maken welke onderstaande methodes verwijderd kunnen worden, sommige staan dubbelzinnig zoals bv verwijderen van een vlucht
@Transactional
@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final Flight flight;
    private final PlaneService planeService;
    private final FlightRouteService flightRouteService;
    private final BookingService bookingService;

    public FlightService(Flight flight, FlightRepository fR, PlaneService pS, FlightRouteService fRS, BookingService bS) {
        this.flight = flight;
        this.flightRepository = fR;
        this.planeService = pS;
        this.flightRouteService = fRS;
        this.bookingService = bS;
    }

    public Flight createFlight(FlightDTO flightDTO) {
        Plane plane = planeService.getPlane(flightDTO.planeId);
        FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.flightRouteId);
        return flightRepository.save(new Flight(flightDTO.departureTime, flightRoute, plane));
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> findFlightsByDeparture(LocalDateTime departure) {
        return flightRepository.findAllByDepartureTime(departure);
    }

    public Flight findFlightRouteAndDeparture(FlightDTO flightDTO) {
        FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.planeId);
        return flightRepository.findByRouteAndDepartureTime(flightRoute, flightDTO.departureTime).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Flight updateFlight(FlightDTO flightDTO, PlaneDTO planeDTO, FlightRouteDTO flightRouteDTO) {
        planeService.updatePlane(planeDTO);
        flightRouteService.updateFlightRoute(flightRouteDTO);

        Flight flight = flightRepository.findById(this.flight.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        flightRepository.save(flight);
        return flight;
    }

    public void deleteFlightByRouteAndDeparture(FlightRoute route, LocalDateTime departure) {
        flightRepository.deleteByDepartureTimeAndRoute(departure, route);
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

    public void addBooking(BookingDTO bookingDTO) {
        flight.addBooking(bookingService.createBooking(bookingDTO));
        flightRepository.save(flight);
    }
}
