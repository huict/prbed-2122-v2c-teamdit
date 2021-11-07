package nl.hu.prbed.airline.booking.presentation.dto;

import nl.hu.prbed.airline.customer.domain.Passenger;
import nl.hu.prbed.airline.booking.domain.Booking;
import nl.hu.prbed.airline.booking.domain.BookingClass;
import nl.hu.prbed.airline.customer.domain.Customer;
import nl.hu.prbed.airline.flight.domain.Flight;

import java.util.List;

public class BookingResponseDTO {
    public Long id;
    public Customer customer;
    public BookingClass bookingClass;
    public List<Flight> flights;
    public List<Passenger> passengers;

    public BookingResponseDTO() {}

    public BookingResponseDTO(Booking booking){
        this.id = booking.getId();
        this.customer = booking.getCustomer();
        this.bookingClass = booking.getBookingClass();
        this.flights = booking.getFlights();
        this.passengers = booking.getPassengers();
    }
}
