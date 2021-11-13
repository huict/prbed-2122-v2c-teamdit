package nl.hu.prbed.airline.booking.application;

import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.domain.BookingClass;
import nl.hu.prbed.airline.booking.presentation.dto.BookingRequestDTO;
import nl.hu.prbed.airline.booking.presentation.dto.BookingResponseDTO;
import nl.hu.prbed.airline.flight.domain.Flight;

import java.util.List;

public interface BookingService {
    Booking createBooking(BookingRequestDTO bookingRequestDTO);

    Booking updateBooking(BookingRequestDTO bookingRequestDTO);

    void deleteBooking(Long id);

    List<BookingResponseDTO> getAllBookings();

    Booking findBookingById(long id);

    int getSeatsLeftForClass(Flight flight, BookingClass bookingClass);
}
