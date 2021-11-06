package nl.hu.prbed.airline.customer.presentation.controller;

import nl.hu.prbed.airline.customer.application.CustomerService;
import nl.hu.prbed.airline.customer.domain.Customer;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerDTO;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerRequestDTO;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerResponseDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Get all customers
    @GetMapping
    public List<Customer> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }

    // Get Customer by id
    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable long id) {
        Customer customer =  this.customerService.findCustomerById(id);
        return new CustomerResponseDTO(customer);
    }

    // Add Customer
    @PostMapping
    public CustomerResponseDTO addCustomer(@Validated @RequestBody CustomerRequestDTO CustomerRequestDTO) {
        Customer customer = this.customerService.createCustomer(CustomerRequestDTO);
        return new CustomerResponseDTO(customer);
    }

    // Update Customer
    @PutMapping
    public CustomerResponseDTO updateCustomer(@Validated @RequestBody CustomerRequestDTO CustomerRequestDTO) {
        Customer customer = this.customerService.updateCustomer(CustomerRequestDTO);
        return new CustomerResponseDTO(customer);
    }

    // Delete Customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
    }

}
