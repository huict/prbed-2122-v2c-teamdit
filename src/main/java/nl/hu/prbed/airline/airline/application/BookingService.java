package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.BookingNotFoundException;
import nl.hu.prbed.airline.airline.data.BookingRepository;
import nl.hu.prbed.airline.airline.domain.Booking;
import nl.hu.prbed.airline.airline.domain.Flight;
import nl.hu.prbed.airline.airline.domain.user.Customer;
import nl.hu.prbed.airline.airline.presentation.dto.BookingDTO;
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

    public Booking createBooking(BookingDTO bookingDTO){
        Customer customer = customerService.findCustomerById(bookingDTO.customerId);
        Flight flight = flightService.findFlightById(bookingDTO.flightId);


        Booking booking = new Booking(customer, bookingDTO.bookingClass, bookingDTO.passengers, flight);

        this.bookingRepository.save(booking);
        return booking;
    }

    public Booking updateBooking(BookingDTO bookingDTO) {
        Customer customer = customerService.findCustomerById(bookingDTO.customerId);
        Flight flight = flightService.findFlightById(bookingDTO.flightId);

        Booking updatedBooking = new Booking(bookingDTO.id, customer, bookingDTO.bookingClass, bookingDTO.passengers, flight);

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
