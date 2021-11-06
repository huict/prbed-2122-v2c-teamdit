package nl.hu.prbed.airline.booking.presentation.dto;

import nl.hu.prbed.airline.customer.domain.Passenger;
import nl.hu.prbed.airline.booking.domain.BookingClass;

import java.util.List;

public class BookingRequestDTO {
    public Long id;
    public Long customerId;
    public BookingClass bookingClass;
    public List<Long> flightsIds;
    public List<Passenger> passengers;

    public BookingRequestDTO() {
    }

}
