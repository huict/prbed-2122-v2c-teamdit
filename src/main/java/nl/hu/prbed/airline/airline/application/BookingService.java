package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.BookingNotFoundException;
import nl.hu.prbed.airline.airline.data.BookingRepository;
import nl.hu.prbed.airline.airline.domain.Booking;
import nl.hu.prbed.airline.airline.domain.user.Customer;
import nl.hu.prbed.airline.airline.presentation.dto.BookingDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerService customerService;

    public BookingService(BookingRepository bookingRepository, CustomerService customerService) {
        this.bookingRepository = bookingRepository;
        this.customerService = customerService;
    }

    public Booking createBooking(BookingDTO bookingDTO){
        Customer customer = customerService.findCustomerById(bookingDTO.customerId);

        Booking booking = new Booking(customer, bookingDTO.bookingClass, bookingDTO.passengers);

        this.bookingRepository.save(booking);
        return booking;
    }

    public Booking updateBooking(BookingDTO bookingDTO) {
        Customer customer = customerService.findCustomerById(bookingDTO.customerId);

        Booking updatedBooking = new Booking(bookingDTO.id, customer, bookingDTO.bookingClass, bookingDTO.passengers);

        bookingRepository.findByid(updatedBooking.getId())
                .orElseThrow(() -> new BookingNotFoundException(updatedBooking.getId()));

        bookingRepository.saveAndFlush(updatedBooking);
        return updatedBooking;
    }

    public void deleteBooking(Long id) {
        this.bookingRepository.findByid(id)
                .orElseThrow(() -> new BookingNotFoundException(id));

        this.bookingRepository.deleteById(id);
    }


    public List<Booking> getAllBookings() {
        return this.bookingRepository.findAll();
    }

    public Booking findBookingById(long id) {
        return this.bookingRepository.findByid(id)
                .orElseThrow(() -> new BookingNotFoundException(id));
    }
}
