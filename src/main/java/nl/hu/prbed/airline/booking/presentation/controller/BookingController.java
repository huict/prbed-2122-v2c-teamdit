package nl.hu.prbed.airline.booking.presentation.controller;

import nl.hu.prbed.airline.booking.application.BookingService;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.presentation.dto.BookingDTO;
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
    public BookingDTO addBooking(@Validated @RequestBody BookingDTO bookingDTO) {
        Booking booking = this.bookingService.createBooking(bookingDTO);
        return new BookingDTO(booking);
    }

    // Update booking
    @PutMapping
    public BookingDTO updateBooking(@Validated @RequestBody BookingDTO bookingDTO) {
        Booking booking = this.bookingService.updateBooking(bookingDTO);
        return new BookingDTO(booking);
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        this.bookingService.deleteBooking(id);
    }
}
