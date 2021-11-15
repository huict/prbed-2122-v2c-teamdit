package nl.hu.prbed.airline.customer.application;

import nl.hu.prbed.airline.customer.application.exception.CustomerNotFoundException;
import nl.hu.prbed.airline.customer.data.CustomerRepository;
import nl.hu.prbed.airline.customer.domain.Customer;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerDTO;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerRequestDTO;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerResponseDTO;
import nl.hu.prbed.airline.customer.presentation.exception.CustomerEmailAddressAlreadyInUseHTTPException;
import nl.hu.prbed.airline.customer.presentation.exception.CustomerPhoneNumberAlreadyInUseHTTPException;
import nl.hu.prbed.airline.security.application.UserService;
import nl.hu.prbed.airline.security.domain.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserService userService;

    public CustomerServiceImpl(CustomerRepository customerRepository, @Lazy UserService userService) {
        this.customerRepository = customerRepository;
        this.userService = userService;
    }

    public Customer createCustomer(CustomerRequestDTO customerRequestDTO) {
        User user = userService.getUser(customerRequestDTO);
        String email = customerRequestDTO.emailAddress;
        Long phone = customerRequestDTO.phoneNumber;

        Customer customer = new Customer(user.getId(),
                customerRequestDTO.firstName,
                customerRequestDTO.lastName,
                customerRequestDTO.dateOfBirth,
                customerRequestDTO.phoneNumber,
                customerRequestDTO.emailAddress,
                customerRequestDTO.nationality);

        if (customerRepository.existsByEmailAddress(email)) {
            throw new CustomerEmailAddressAlreadyInUseHTTPException(email);
        } else if (customerRepository.existsByPhoneNumber(phone)) {
            throw new CustomerPhoneNumberAlreadyInUseHTTPException(phone);
        }

        this.customerRepository.save(customer);
        return customer;
    }

    public Customer updateCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer updatedCustomer = new Customer(customerRequestDTO.id, customerRequestDTO.firstName, customerRequestDTO.lastName, customerRequestDTO.dateOfBirth, customerRequestDTO.phoneNumber, customerRequestDTO.emailAddress, customerRequestDTO.nationality);
        String email = customerRequestDTO.emailAddress;
        Long phone = customerRequestDTO.phoneNumber;

        customerRepository.findByid(updatedCustomer.getId())
                .orElseThrow(() -> new CustomerNotFoundException(updatedCustomer.getId()));

        if (customerRepository.existsByEmailAddress(email)) {
            throw new CustomerEmailAddressAlreadyInUseHTTPException(email);
        } else if (customerRepository.existsByPhoneNumber(phone)) {
            throw new CustomerPhoneNumberAlreadyInUseHTTPException(phone);
        }

        customerRepository.saveAndFlush(updatedCustomer);
        return updatedCustomer;
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = this.customerRepository.findAll();
        List<CustomerResponseDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOS.add(new CustomerResponseDTO(customer));
        }
        return customerDTOS;
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

    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.id,
                customerDTO.firstName,
                customerDTO.lastName,
                customerDTO.dateOfBirth,
                customerDTO.phoneNumber,
                customerDTO.emailAddress,
                customerDTO.nationality);

        this.customerRepository.save(customer);
    }
}
