package nl.hu.prbed.airline.booking.presentation.dto;

import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.domain.BookingClass;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.airline.domain.user.Passenger;

import java.util.List;

public class BookingDTO {
    public Long id;
    public Long customerId;
    public BookingClass bookingClass;
    public List<Flight> flights;
    public List<Passenger> passengers;

    public BookingDTO(){}

    public BookingDTO(Booking booking){
        this.id = booking.getId();
        this.customerId = booking.getCustomer().getId();
        this.bookingClass = booking.getBookingClass();
        this.flights = booking.getFlights();
        this.passengers = booking.getPassengers();
    }
}
