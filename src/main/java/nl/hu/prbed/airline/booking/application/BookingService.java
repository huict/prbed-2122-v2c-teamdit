package nl.hu.prbed.airline.booking.application;

import nl.hu.prbed.airline.booking.application.exception.NoSeatsLeftForClassException;
import nl.hu.prbed.airline.booking.domain.BookingClass;
import nl.hu.prbed.airline.booking.presentation.dto.BookingRequestDTO;
import nl.hu.prbed.airline.booking.presentation.dto.BookingResponseDTO;
import nl.hu.prbed.airline.customer.application.CustomerService;
import nl.hu.prbed.airline.email.EmailService;
import nl.hu.prbed.airline.flight.application.FlightService;
import nl.hu.prbed.airline.booking.application.exception.BookingNotFoundException;
import nl.hu.prbed.airline.booking.data.BookingRepository;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.customer.domain.Customer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final FlightService flightService;
    private final EmailService emailService;

    public BookingService(BookingRepository bookingRepository, CustomerService customerService,@Lazy FlightService flightService, EmailService emailService) {
        this.bookingRepository = bookingRepository;
        this.customerService = customerService;
        this.flightService = flightService;
        this.emailService = emailService;
    }

    public Booking createBooking(BookingRequestDTO bookingRequestDTO){
        List<Flight> flights = new ArrayList<>();
        Customer customer = customerService.findCustomerById(bookingRequestDTO.customerId);
        for(Long flightId : bookingRequestDTO.flightsIds){
            Flight flight = flightService.findFlightById(flightId);
            flights.add(flight);
        }

        for (Flight flight: flights) {
            int seatsLeft = getSeatsLeftForClass(flight, bookingRequestDTO.bookingClass);

            if (seatsLeft < bookingRequestDTO.passengers.size() + 1) {
                throw new NoSeatsLeftForClassException();
            }
        }
        Booking booking = new Booking(customer, bookingRequestDTO.bookingClass, flights, bookingRequestDTO.passengers);
        this.emailService.sendEmail(customer.getEmailAddress(), booking);
        this.bookingRepository.save(booking);

        return booking;
    }

    public Booking updateBooking(BookingRequestDTO bookingRequestDTO) {
        List<Flight> flights = new ArrayList<>();
        Customer customer = customerService.findCustomerById(bookingRequestDTO.customerId);

        for(Long id : bookingRequestDTO.flightsIds){
            Flight flight = flightService.findFlightById(id);
            flights.add(flight);
        }

        Booking updatedBooking = new Booking( bookingRequestDTO.id ,customer, bookingRequestDTO.bookingClass, flights, bookingRequestDTO.passengers);

        bookingRepository.findByid(updatedBooking.getId()).orElseThrow(() -> new BookingNotFoundException(updatedBooking.getId()));

        bookingRepository.saveAndFlush(updatedBooking);
        return updatedBooking;
    }

    public void deleteBooking(Long id) {
        this.bookingRepository.findByid(id)
                .orElseThrow(() -> new BookingNotFoundException(id));

        this.bookingRepository.deleteById(id);
    }

    public List<BookingResponseDTO> getAllBookings() {
        List<Booking> bookings = this.bookingRepository.findAll();
        List<BookingResponseDTO> bookingDTOs = new ArrayList<>();
        for (Booking booking : bookings) {
            bookingDTOs.add(new BookingResponseDTO(booking));
        }
        return bookingDTOs;
    }

    public Booking findBookingById(long id) {
        return this.bookingRepository.findByid(id)
                .orElseThrow(() -> new BookingNotFoundException(id));
    }

    private int getSeatsLeftForClass(Flight flight, BookingClass bookingClass) {
        List<Booking> bookings = bookingRepository.findAllByFlightsContainsAndBookingClass(flight, bookingClass);

        int seatsLeft = flight.getPlane().getSeatsFor(bookingClass);


        for (Booking booking: bookings) {
            seatsLeft -= booking.getAmountOfPassengers();
        }

        return seatsLeft;
    }
}
