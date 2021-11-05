package nl.hu.prbed.airline.booking.presentation.dto;

import nl.hu.prbed.airline.airline.domain.user.Passenger;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.domain.BookingClass;
import nl.hu.prbed.airline.flight.domain.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class BookingRequestDTO {
    public Long id;
    public Long customerId;
    public BookingClass bookingClass;
    public List<Long> flightsIds;
    public List<Passenger> passengers;

    public BookingRequestDTO() {
    }
}
