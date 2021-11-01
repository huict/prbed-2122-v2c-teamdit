package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.BookingNotFoundException;
import nl.hu.prbed.airline.airline.application.exception.CustomerNotFoundException;
import nl.hu.prbed.airline.airline.data.CustomerRepository;
import nl.hu.prbed.airline.airline.domain.user.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(long id) {
        return this.customerRepository.findByid(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
