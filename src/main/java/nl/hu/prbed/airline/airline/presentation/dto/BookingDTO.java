package nl.hu.prbed.airline.airline.presentation.dto;

import nl.hu.prbed.airline.airline.domain.Booking;
import nl.hu.prbed.airline.airline.domain.BookingClass;
import nl.hu.prbed.airline.airline.domain.user.Customer;
import nl.hu.prbed.airline.airline.domain.user.Passenger;

import java.util.List;

public class BookingDTO {
    public Long id;
    public Long customerId;
    public BookingClass bookingClass;
    public List<Passenger> passengers;

    public BookingDTO(){}

    public BookingDTO(Booking booking){
        this.id = booking.getId();
        this.customerId = booking.getCustomer().getId();
        this.bookingClass = booking.getBookingClass();
        this.passengers = booking.getPassengers();
    }

}
