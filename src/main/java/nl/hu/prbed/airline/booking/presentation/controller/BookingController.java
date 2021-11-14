package nl.hu.prbed.airline.booking.presentation.controller;

import nl.hu.prbed.airline.booking.application.BookingService;
import nl.hu.prbed.airline.booking.application.BookingServiceImpl;
import nl.hu.prbed.airline.booking.application.exception.BookingNotFoundException;
import nl.hu.prbed.airline.booking.application.exception.NoSeatsLeftForClassException;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.presentation.dto.BookingRequestDTO;
import nl.hu.prbed.airline.booking.presentation.dto.BookingResponseDTO;
import nl.hu.prbed.airline.booking.presentation.exception.BookingInUseHTTPException;
import nl.hu.prbed.airline.booking.presentation.exception.BookingNotFoundHTTPException;
import nl.hu.prbed.airline.booking.presentation.exception.NoSeatsLeftForClassHTTPException;
import nl.hu.prbed.airline.customer.application.exception.CustomerNotFoundException;
import nl.hu.prbed.airline.customer.presentation.exception.CustomerNotFoundHTTPException;
import nl.hu.prbed.airline.flight.application.exception.FlightNotFoundException;
import nl.hu.prbed.airline.flight.presentation.exception.FlightNotFoundHTTPException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/booking")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingServiceImpl bookingService){
        this.bookingService = bookingService;
    }

    // Get all bookings
    @GetMapping
    public List<BookingResponseDTO> getAllBookings(){
        return this.bookingService.getAllBookings();
    }

    // Get booking by id
    @GetMapping("/{id}")
    public BookingResponseDTO getBookingById(@PathVariable long id) {
        try{
            Booking booking = this.bookingService.findBookingById(id);
            return new BookingResponseDTO(booking);
        } catch (BookingNotFoundException e){
            throw new BookingNotFoundHTTPException(id);
        }

    }

    // Add booking
    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public BookingResponseDTO addBooking(@Validated @RequestBody BookingRequestDTO bookingRequestDTO) {
        try {
            Booking booking = this.bookingService.createBooking(bookingRequestDTO);
            return new BookingResponseDTO(booking);
        }
        catch (NoSeatsLeftForClassException e){
            throw new NoSeatsLeftForClassHTTPException();
        }
        catch (CustomerNotFoundException e){
            throw new CustomerNotFoundHTTPException(bookingRequestDTO.customerId);
        }
        catch (FlightNotFoundException e){
            throw new FlightNotFoundHTTPException();
        }
    }

    // Update booking
    @PutMapping
    public BookingResponseDTO updateBooking(@Validated @RequestBody BookingRequestDTO bookingRequestDTO) {
        try {
            Booking booking = this.bookingService.updateBooking(bookingRequestDTO);
            return new BookingResponseDTO(booking);
        } catch (BookingNotFoundException e){
            throw new BookingNotFoundHTTPException(bookingRequestDTO.id);
        }
        catch (NoSeatsLeftForClassException e){
            throw new NoSeatsLeftForClassHTTPException();
        }
        catch (CustomerNotFoundException e){
            throw new CustomerNotFoundHTTPException(bookingRequestDTO.customerId);
        }
        catch (FlightNotFoundException e){
            throw new FlightNotFoundHTTPException();
        }
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        try {
            this.bookingService.deleteBooking(id);
        } catch (BookingNotFoundException e){
            throw new BookingNotFoundHTTPException(id);
        } catch (DataIntegrityViolationException e){
            throw new BookingInUseHTTPException();
        }
    }
}
