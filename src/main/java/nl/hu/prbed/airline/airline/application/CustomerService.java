package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.CustomerNotFoundException;
import nl.hu.prbed.airline.airline.data.CustomerRepository;
import nl.hu.prbed.airline.airline.domain.user.Customer;
import nl.hu.prbed.airline.airline.presentation.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerDTO customerDTO){

        Customer customer = new Customer(customerDTO.firstName, customerDTO.lastName, customerDTO.dateOfBirth, customerDTO.phoneNumber, customerDTO.emailAddress , customerDTO.nationality);

        this.customerRepository.save(customer);
        return customer;
    }

    public Customer updateCustomer(CustomerDTO customerDTO) {

        Customer updatedCustomer = new Customer(customerDTO.firstName, customerDTO.lastName, customerDTO.dateOfBirth, customerDTO.phoneNumber, customerDTO.emailAddress , customerDTO.nationality);

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
