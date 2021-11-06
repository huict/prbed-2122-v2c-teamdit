package nl.hu.prbed.airline.booking.presentation.controller;

import nl.hu.prbed.airline.booking.application.BookingService;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.presentation.dto.BookingRequestDTO;
import nl.hu.prbed.airline.booking.presentation.dto.BookingResponseDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/booking")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    // Get all bookings
    @GetMapping
    public List<BookingResponseDTO> getAllBookings(){
        return this.bookingService.getAllBookings();
    }

    // Get booking by id
    @GetMapping("/{id}")
    public BookingResponseDTO getBookingByCode(@PathVariable long id) {
        Booking booking = this.bookingService.findBookingById(id);
        return new BookingResponseDTO(booking);
    }

    // Add booking
    @PostMapping
    public BookingResponseDTO addBooking(@Validated @RequestBody BookingRequestDTO bookingRequestDTO) {
        Booking booking = this.bookingService.createBooking(bookingRequestDTO);
        return new BookingResponseDTO(booking);
    }

    // Update booking
    @PutMapping
    public BookingResponseDTO updateBooking(@Validated @RequestBody BookingRequestDTO BookingRequestDTO) {
        Booking booking = this.bookingService.updateBooking(BookingRequestDTO);
        return new BookingResponseDTO(booking);
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        this.bookingService.deleteBooking(id);
    }
}
