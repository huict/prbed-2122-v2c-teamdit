package nl.hu.prbed.airline.booking.data;

import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.domain.BookingClass;
import nl.hu.prbed.airline.flight.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository  extends JpaRepository<Booking,Long> {
    Optional<Booking> findByid(Long id);
    void deleteById(Long id);

    List<Booking> findAllByFlightsContainsAndBookingClass(Flight flight, BookingClass bookingClass);
}
