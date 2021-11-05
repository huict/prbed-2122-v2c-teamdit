package nl.hu.prbed.airline.booking.application;

import nl.hu.prbed.airline.booking.presentation.dto.BookingRequestDTO;
import nl.hu.prbed.airline.customer.application.CustomerService;
import nl.hu.prbed.airline.flight.application.FlightService;
import nl.hu.prbed.airline.booking.application.exception.BookingNotFoundException;
import nl.hu.prbed.airline.booking.data.BookingRepository;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.customer.domain.Customer;
import nl.hu.prbed.airline.booking.presentation.dto.BookingDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final FlightService flightService;

    public BookingService(BookingRepository bookingRepository, CustomerService customerService, FlightService flightService) {
        this.bookingRepository = bookingRepository;
        this.customerService = customerService;
        this.flightService = flightService;
    }

    public Booking createBooking(BookingRequestDTO bookingRequestDTO){
        List<Flight> flights = null;
        Customer customer = customerService.findCustomerById(bookingRequestDTO.customerId);

        for(Long id :bookingRequestDTO.flightsIds){
            Flight flight = flightService.findFlightById(id);
            flights.add(flight);
        }

        Booking booking = new Booking(customer, bookingRequestDTO.bookingClass, flights, bookingRequestDTO.passengers);

        this.bookingRepository.save(booking);
        return booking;
    }

    public Booking updateBooking(BookingDTO bookingDTO) {
        Customer customer = customerService.findCustomerById(bookingDTO.customerId);

        Booking updatedBooking = new Booking(bookingDTO.id, customer, bookingDTO.bookingClass, bookingDTO.flights, bookingDTO.passengers);

        bookingRepository.findByid(updatedBooking.getId())
                .orElseThrow(() -> new BookingNotFoundException(updatedBooking.getId()));

        bookingRepository.saveAndFlush(updatedBooking);
        return updatedBooking;
    }

    public void deleteBooking(Long id) {
        this.bookingRepository.findByid(id)
                .orElseThrow(() -> new BookingNotFoundException(id));

        this.bookingRepository.deleteById(id);
    }

    public List<Booking> getAllBookings() {
        return this.bookingRepository.findAll();
    }

    public Booking findBookingById(long id) {
        return this.bookingRepository.findByid(id)
                .orElseThrow(() -> new BookingNotFoundException(id));
    }
}
