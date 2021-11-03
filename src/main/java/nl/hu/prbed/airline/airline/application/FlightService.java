package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.FlightNotFoundException;
import nl.hu.prbed.airline.airline.application.exception.InvalidDTOException;
import nl.hu.prbed.airline.airline.data.FlightRepository;
import nl.hu.prbed.airline.airline.domain.Booking;
import nl.hu.prbed.airline.airline.domain.Flight;
import nl.hu.prbed.airline.airline.domain.FlightRoute;
import nl.hu.prbed.airline.airline.domain.Plane;
import nl.hu.prbed.airline.airline.presentation.dto.Flight.FlightBookingDTO;
import nl.hu.prbed.airline.airline.presentation.dto.Flight.FlightDTO;
import nl.hu.prbed.airline.airline.presentation.dto.Flight.FlightDepartureRouteDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

//laten we de afweging maken welke onderstaande methodes verwijderd kunnen worden, sommige staan dubbelzinnig zoals bv verwijderen van een vlucht
@Transactional
@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final Flight flight;
    private final FleetService fleetService;
    private final FlightRouteService flightRouteService;
    private final BookingService bookingService;
    private final PlaneService planeService;

    public FlightService(Flight flight, FlightRepository fR, FleetService fS, FlightRouteService fRS, BookingService bS, PlaneService pS) {
        this.flight = flight;
        this.flightRepository = fR;
        this.fleetService = fS;
        this.flightRouteService = fRS;
        this.bookingService = bS;
        this.planeService = pS;
    }

    public Flight createFlight(FlightDTO flightDTO) {
        if(flightDTO.flightRouteId == null || flightDTO.departureTime == null || flightDTO.planeId == null){
            throw new InvalidDTOException("Missing some input variables to send!");
        }

        Plane plane = planeService.getPlane(flightDTO.planeId);
        FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.flightRouteId);
        return flightRepository.save(new Flight(flightDTO.departureTime, flightRoute, plane));
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findFlightById(Long id) {
        if(id == null){
            throw new InvalidDTOException("No id specified!");
        }
        return flightRepository.findById(id).orElseThrow(FlightNotFoundException::new);

    }

    public List<Flight> findFlightsByDeparture(Date departure) {
        if(departure == null){
            throw new InvalidDTOException("No departure specified");
        }
        return flightRepository.findAllByDepartureTime(departure);
    }

    public Flight findFlightRouteAndDeparture(FlightDepartureRouteDTO flightDepartureRoute) {
        if(flightDepartureRoute == null){
            throw new InvalidDTOException("No id specified!");
        }
        FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDepartureRoute.flightRouteId);
        return flightRepository.findByRouteAndDepartureTime(flightRoute, flightDepartureRoute.departureTime).orElseThrow(FlightNotFoundException::new);
    }

    public Flight updateFlight(FlightDTO flightDTO, Long id) {
        if(id == null){
            throw new InvalidDTOException("No id specified!");
        }

        Flight flight = findFlightById(id);
        FlightRoute flightRoute = flightRouteService.findFlightRouteByID(flightDTO.flightRouteId);
        Plane plane = planeService.getPlane(flightDTO.planeId);
        flight.update(flightDTO.departureTime, flightRoute, plane);
        flightRepository.save(flight);
        return flight;
    }

    public void deleteFlightByRouteAndDeparture(FlightRoute route, Date departure) {
        if(flightRepository.findByRouteAndDepartureTime(route, departure).isEmpty()){
            throw new FlightNotFoundException();
        }
        flightRepository.deleteByDepartureTimeAndRoute(departure, route);
    }

    public void deleteFlightById(Long id) {
        if(id == null){
            throw new InvalidDTOException("No id specified!");
        }
        else if(flightRepository.findById(id).isEmpty()){
            throw new FlightNotFoundException();
        }
        flightRepository.deleteById(id);
    }

    public void addBooking(FlightBookingDTO flightBooking) {
        if(flightBooking.bookingId == null || flightBooking.flightId == null){
            throw new InvalidDTOException("Missing input variables to send!");
        }
        Booking booking = bookingService.findBookingById(flightBooking.bookingId);
        Flight flight = findFlightById(flightBooking.flightId);
        flight.addBooking(booking);
        flightRepository.save(flight);
    }

}
