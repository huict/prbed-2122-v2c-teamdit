package nl.hu.prbed.airline.customer.presentation.controller;

import nl.hu.prbed.airline.customer.application.CustomerService;
import nl.hu.prbed.airline.customer.domain.Customer;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
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
    public Customer getCustomerById(@PathVariable long id) {
        return this.customerService.findCustomerById(id);
    }

    // Add Customer
    @PostMapping
    public CustomerDTO addCustomer(@Validated @RequestBody CustomerDTO customerDTO) {
        Customer customer = this.customerService.createCustomer(customerDTO);
        return new CustomerDTO(customer);
    }

    // Update Customer
    @PutMapping
    public CustomerDTO updateCustomer(@Validated @RequestBody CustomerDTO customerDTO) {
        Customer customer = this.customerService.updateCustomer(customerDTO);
        return new CustomerDTO(customer);
    }

    // Delete Customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
    }

}
