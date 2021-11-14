package nl.hu.prbed.airline.customer.presentation.controller;

import nl.hu.prbed.airline.customer.application.CustomerService;
import nl.hu.prbed.airline.customer.application.CustomerServiceImpl;
import nl.hu.prbed.airline.customer.application.exception.CustomerNotFoundException;
import nl.hu.prbed.airline.customer.domain.Customer;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerRequestDTO;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerResponseDTO;
import nl.hu.prbed.airline.customer.presentation.exception.CustomerEmailAddressAlreadyInUseHTTPException;
import nl.hu.prbed.airline.customer.presentation.exception.CustomerNotFoundHTTPException;
import nl.hu.prbed.airline.customer.presentation.exception.CustomerPhoneNumberAlreadyInUseHTTPException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    //Get all customers
    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    // Get Customer by id
    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable long id) {
        try {
            Customer customer = this.customerService.findCustomerById(id);
            return new CustomerResponseDTO(customer);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundHTTPException(id);
        }
    }

    // Add Customer
    @PostMapping
    public CustomerResponseDTO addCustomer(@Validated @RequestBody CustomerRequestDTO customerRequestDTO) {
        try {
            Customer customer = this.customerService.createCustomer(customerRequestDTO);
            return new CustomerResponseDTO(customer);
        } catch (CustomerPhoneNumberAlreadyInUseHTTPException e) {
            throw new CustomerPhoneNumberAlreadyInUseHTTPException(customerRequestDTO.phoneNumber);
        } catch (CustomerEmailAddressAlreadyInUseHTTPException e) {
            throw new CustomerEmailAddressAlreadyInUseHTTPException(customerRequestDTO.emailAddress);
        }
    }

    // Update Customer
    @PutMapping
    public CustomerResponseDTO updateCustomer(@Validated @RequestBody CustomerRequestDTO customerRequestDTO) {
        try {
            Customer customer = this.customerService.updateCustomer(customerRequestDTO);
            return new CustomerResponseDTO(customer);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundHTTPException(customerRequestDTO.id);
        } catch (CustomerPhoneNumberAlreadyInUseHTTPException e) {
            throw new CustomerPhoneNumberAlreadyInUseHTTPException(customerRequestDTO.phoneNumber);
        } catch (CustomerEmailAddressAlreadyInUseHTTPException e) {
            throw new CustomerEmailAddressAlreadyInUseHTTPException(customerRequestDTO.emailAddress);
        }
    }

    // Delete Customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        try {
            this.customerService.deleteCustomer(id);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundHTTPException(id);
        }
    }

}
