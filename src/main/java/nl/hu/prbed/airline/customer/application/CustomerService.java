package nl.hu.prbed.airline.customer.application;

import nl.hu.prbed.airline.customer.application.exception.CustomerNotFoundException;
import nl.hu.prbed.airline.customer.data.CustomerRepository;
import nl.hu.prbed.airline.customer.domain.Customer;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerDTO;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerRequestDTO customerRequestDTO){

        Customer customer = new Customer(customerRequestDTO.firstName, customerRequestDTO.lastName, customerRequestDTO.dateOfBirth, customerRequestDTO.phoneNumber, customerRequestDTO.emailAddress , customerRequestDTO.nationality);

        this.customerRepository.save(customer);
        return customer;
    }

    public Customer updateCustomer(CustomerRequestDTO customerRequestDTO) {

        Customer updatedCustomer = new Customer(customerRequestDTO.firstName, customerRequestDTO.lastName, customerRequestDTO.dateOfBirth, customerRequestDTO.phoneNumber, customerRequestDTO.emailAddress , customerRequestDTO.nationality);

        customerRepository.findByid(updatedCustomer.getId())
                .orElseThrow(() -> new CustomerNotFoundException(updatedCustomer.getId()));

        customerRepository.saveAndFlush(updatedCustomer);
        return updatedCustomer;
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    public void deleteCustomer(Long id) {
        this.customerRepository.findByid(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        this.customerRepository.deleteById(id);
    }

    public Customer findCustomerById(long id) {
        return this.customerRepository.findByid(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
