package nl.hu.prbed.airline.booking.presentation.controller;

import nl.hu.prbed.airline.booking.application.BookingService;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.presentation.dto.BookingDTO;
import nl.hu.prbed.airline.booking.presentation.dto.BookingRequestDTO;
import nl.hu.prbed.airline.booking.presentation.dto.BookingResponseDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings(){
        return this.bookingService.getAllBookings();
    }

    // Get booking by id
    @GetMapping("/{id}")
    public Booking getAirportByCode(@PathVariable long id) {
        return this.bookingService.findBookingById(id);
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
